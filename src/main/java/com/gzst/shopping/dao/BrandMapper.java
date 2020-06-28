package com.gzst.shopping.dao;

import com.gzst.shopping.model.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {
    public List<Brand> findAllBrands();

    public Integer insertBrand(Brand brand);

    public Brand findOne(Integer id);

    public Integer updateBrand(Brand brand);

    public Integer deleteBrand(@Param("array") Integer[] id);
}
