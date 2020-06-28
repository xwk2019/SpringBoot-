package com.gzst.shopping.service;

import com.gzst.shopping.model.SpecOptions;
import com.gzst.shopping.model.Specification;
import com.gzst.shopping.utils.PageResult;
import com.gzst.shopping.utils.Result;

public interface SpecificationService {
    public PageResult<Specification> findPage(Integer pageNo, Integer pageSize);

    public Result save(SpecOptions specOptions);

    public Result deleteSpecification(Long id);

    public SpecOptions findOne(Long id);

    public Result update(SpecOptions specOptions);
}
