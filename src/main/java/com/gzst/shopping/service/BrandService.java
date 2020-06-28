package com.gzst.shopping.service;

import com.gzst.shopping.model.Brand;
import com.gzst.shopping.utils.PageResult;
import com.gzst.shopping.utils.Result;

import java.util.List;

public interface BrandService {
    public List<Brand> findAllBrands();

    public PageResult<Brand> findPage(Integer pageNo, Integer pageSize);

    public Result saveBrand(Brand brand);

    public Brand findOne(Integer id);

    public Result updateBrand(Brand brand);

    public Result deleteBrand(Integer[] id);
}
