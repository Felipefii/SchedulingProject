package com.schedulingproject.project.product.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Long idcategory;
    private Long dtinsert;
    private Long dtupdate;

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getDtinsert() {
        return dtinsert;
    }

    public void setDtinsert(Long dtinsert) {
        this.dtinsert = dtinsert;
    }

    public Long getDtupdate() {
        return dtupdate;
    }

    public void setDtupdate(Long dtupdate) {
        this.dtupdate = dtupdate;
    }

    public Long getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Long idcategory) {
        this.idcategory = idcategory;
    }
}
