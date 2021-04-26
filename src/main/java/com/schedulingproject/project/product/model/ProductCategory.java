package com.schedulingproject.project.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schedulingproject.project.product.dto.ProductCategoryDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;

    public ProductCategory() {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return id.equals(that.id) && name.equals(that.name) && products.equals(that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }

    public ProductCategory of(ProductCategoryDTO productCategoryDTO) {
        ProductCategory category = new ProductCategory();
        category.setName(productCategoryDTO.getName());
        return category;
    }
}


