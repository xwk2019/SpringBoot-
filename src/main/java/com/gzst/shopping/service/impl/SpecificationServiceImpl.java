package com.gzst.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gzst.shopping.dao.SpecificationMapper;
import com.gzst.shopping.dao.SpecificationOptionMapper;
import com.gzst.shopping.model.SpecOptions;
import com.gzst.shopping.model.Specification;
import com.gzst.shopping.model.SpecificationOption;
import com.gzst.shopping.service.SpecificationService;
import com.gzst.shopping.utils.PageResult;
import com.gzst.shopping.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Resource
    private SpecificationMapper specificationMapper;
    @Resource
    private SpecificationOptionMapper specificationOptionMapper;

    @Override
    public PageResult<Specification> findPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<Specification> page = (Page<Specification>) specificationMapper.findAll();
        PageResult<Specification> pageResult = new PageResult<>(page.getTotal(), page.getResult());
        return pageResult;
    }

    @Override
    public Result save(SpecOptions specOptions) {
        Result result = null;
        try {
            Specification specification = specOptions.getSpecification();
            specificationMapper.insertSpecification(specification);
            for (SpecificationOption option : specOptions.getOptions()) {
                option.setSpecId(specification.getId());
                specificationOptionMapper.insertOption(option);
            }
            result = new Result(true, "数据保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "数据保存失败");
        }
        return result;

    }

    @Override
    public Result deleteSpecification(Long id) {
        Result result = null;
        try {
            specificationOptionMapper.deleteOptionsBySpecId(id);
            if (specificationOptionMapper.deleteOptionsBySpecId(id) == 0 && specificationMapper.deleteSpecification(id) == 0)
                result = new Result(false, "该" + id + "规格不存在");
            else
                result = new Result(true, "数据删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "数据删除失败");
        }
        return result;
    }

    @Override
    public SpecOptions findOne(Long id) {
        SpecOptions specOptions = new SpecOptions();
        Specification specification = null;
        List<SpecificationOption> options = null;
        try {
            specification = specificationMapper.selectOne(id);
            options = specificationOptionMapper.selectOptionsBySpecId(id);
            specOptions.setSpecification(specification);
            specOptions.setOptions(options);
        } catch (Exception e) {
            e.printStackTrace();
            specification = new Specification(-1L, "不存在");
            specOptions.setSpecification(specification);
        }
        return specOptions;
    }

    @Override
    public Result update(SpecOptions specOptions) {
        //三个:删除options,添加options，修改specification
        Result result = null;
        Specification specification = specOptions.getSpecification();
        List<SpecificationOption> options = specOptions.getOptions();
        try {
            specificationOptionMapper.deleteOptionsBySpecId(specification.getId());
            specificationMapper.updateSpecification(specification);
            for (SpecificationOption option : options) {
                option.setSpecId(specification.getId());
                specificationOptionMapper.insertOption(option);
            }
            result = new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "修改失败");
        }
        return result;
    }
}
