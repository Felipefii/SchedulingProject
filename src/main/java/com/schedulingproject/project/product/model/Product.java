package com.schedulingproject.project.product.model;

import com.schedulingproject.project.product.dto.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long dtinsert;
    private Long dtupdate;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @PrePersist
    public void prePersist(){
        this.dtinsert = this.dtupdate = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate(){
        this.dtupdate = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    public Product of(ProductDTO productDTO) {
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
