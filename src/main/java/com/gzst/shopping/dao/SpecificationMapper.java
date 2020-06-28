package com.gzst.shopping.dao;

import com.gzst.shopping.model.Specification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecificationMapper {
    public List<Specification> findAll();

    public Integer insertSpecification(Specification specification);

    public Integer deleteSpecification(Long id);

    public Specification selectOne(Long id);

    public Integer updateSpecification(Specification specification);
}
