package com.gzst.shopping.controller;

import com.gzst.shopping.model.SpecOptions;
import com.gzst.shopping.model.Specification;
import com.gzst.shopping.service.SpecificationService;
import com.gzst.shopping.utils.PageResult;
import com.gzst.shopping.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 品牌规格的controller
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;

    @RequestMapping("/findPage")
    public PageResult<Specification> findPage(Integer pageNo, Integer pageSize) {
        if (pageNo <= 0)
            pageNo = 1;
        if (pageSize <= 0)
            pageSize = 10;
        PageResult pageResult = specificationService.findPage(pageNo, pageSize);
        return pageResult;

    }

    @RequestMapping("/saveEntity")
    public Result saveEntity(@RequestBody SpecOptions entity) {
        Result result = null;
        if (entity.getSpecification() != null && entity.getSpecification().getId() != null) {
            //三个:删除options,添加options，修改specification
            result = specificationService.update(entity);
        } else {
            if (entity.getSpecification().getSpecName() == null || entity.getSpecification().getSpecName() == "")
                result = new Result(false, "speciname不能为空");
            else {
                //添加两个：specification, options
                result = specificationService.save(entity);
            }
        }
        return result;
    }

    @RequestMapping("/deleteSpecification")
    public Result deleteSpecification(Long id) {
        Result result = null;
        if (id <= 0)
            result = new Result(false, "id值不合法");
        else {
            result = specificationService.deleteSpecification(id);
        }
        return result;
    }

    @RequestMapping("/findOne")
    public SpecOptions findOne(Long id) {
        return specificationService.findOne(id);
    }
}
