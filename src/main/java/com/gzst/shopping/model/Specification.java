package com.gzst.shopping.model;

/**
 * 品牌规格类
 */
public class Specification {
    private Long id;
    private String specName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Specification() {
    }

    public Specification(Long id, String specName) {
        this.id = id;
        this.specName = specName;
    }
}
