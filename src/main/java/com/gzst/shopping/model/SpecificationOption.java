package com.gzst.shopping.model;

/**
 * 规格选项类
 */
public class SpecificationOption {
    private Long id;
    private String optionName;
    private Long specId;
    private Integer orders;

    public SpecificationOption() {
    }

    public SpecificationOption(Long id, String optionName, Long specId, Integer orders) {
        this.id = id;
        this.optionName = optionName;
        this.specId = specId;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
