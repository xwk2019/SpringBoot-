package com.gzst.shopping.controller;

import com.gzst.shopping.model.Brand;
import com.gzst.shopping.service.BrandService;
import com.gzst.shopping.utils.PageResult;
import com.gzst.shopping.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/getAllBrands")
    public List<Brand> getAllBrands() {

        return brandService.findAllBrands();
    }

    @RequestMapping("/findPage")
    public PageResult<Brand> findPage(Integer pageNo, Integer pageSize) {
        PageResult<Brand> pageResult = null;
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize <= 0 || pageSize >= 100) {
            pageSize = 10;
        }
        pageResult = brandService.findPage(pageNo, pageSize);
        return pageResult;
    }

    @RequestMapping("/saveBrand")
    public Result saveBrand(@RequestBody Brand brand) {
        Result result = null;
        if (brand == null || brand.getName() == null || brand.getFirstChar() == null) {
            result = new Result(true, "请输入相关信息");
        } else {
            result = brandService.saveBrand(brand);
        }
        return result;
    }

    @RequestMapping("/findOne")
    public Brand findOne(Integer id) {
        Brand brand = null;
        if (id > 0)
            brand = brandService.findOne(id);
        return brand;
    }

    @RequestMapping("/updateBrand")
    public Result updateBrand(@RequestBody Brand brand) {
        Result result = null;
        if (brand == null || brand.getName() == null || brand.getFirstChar() == null || brand.getId() == null) {
            result = new Result(true, "请输入相关信息");
        } else {
            result = brandService.updateBrand(brand);
        }
        return result;
    }

    @RequestMapping("/deleteBrand")
    public Result deleteBrand(@RequestBody Integer[] id) {
        Result result = null;
        if (id == null) {
            result = new Result(true, "请输入相关信息");
        } else {
            result = brandService.deleteBrand(id);
        }
        return result;
    }
}


