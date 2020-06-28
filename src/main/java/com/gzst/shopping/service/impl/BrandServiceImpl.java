package com.gzst.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gzst.shopping.dao.BrandMapper;
import com.gzst.shopping.model.Brand;
import com.gzst.shopping.service.BrandService;
import com.gzst.shopping.utils.PageResult;
import com.gzst.shopping.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAllBrands() {
        return brandMapper.findAllBrands();
    }

    @Override
    public PageResult<Brand> findPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<Brand> brandPage = (Page<Brand>) brandMapper.findAllBrands();
        PageResult<Brand> pageResult = new PageResult<>(brandPage.getTotal(), brandPage.getResult());
        return pageResult;
    }

    @Override
    public Result saveBrand(Brand brand) {
        Result result = null;
        Integer ret = brandMapper.insertBrand(brand);
        if (ret == 1) {
            result = new Result(true, "保存成功");
        } else {
            result = new Result(false, "保存失败");
        }
        return result;
    }

    @Override
    public Brand findOne(Integer id) {
        return brandMapper.findOne(id);
    }

    @Override
    public Result updateBrand(Brand brand) {
        Result result = null;
        Integer ret = brandMapper.updateBrand(brand);
        if (ret == 1) {
            result = new Result(true, "更新成功");
        } else {
            result = new Result(false, "更新失败");
        }
        return result;
    }

    @Override
    public Result deleteBrand(Integer[] id) {
        Result result = null;
        Integer ret = brandMapper.deleteBrand(id);
        if (ret == 1) {
            result = new Result(false, "更新成功");
        } else {
            result = new Result(true, "更新失败");
        }
        return result;
    }


}
