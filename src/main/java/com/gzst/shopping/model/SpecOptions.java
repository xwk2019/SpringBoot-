package com.gzst.shopping.model;

import java.util.List;

/**
 * 上传两个表的信息
 */
public class SpecOptions {
    private Specification specification;
    private List<SpecificationOption> options;

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<SpecificationOption> getOptions() {
        return options;
    }

    public void setOptions(List<SpecificationOption> options) {
        this.options = options;
    }
}
