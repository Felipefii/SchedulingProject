package com.schedulingproject.project.product.service;

import com.schedulingproject.project.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

    List<ProductCategory> getAllProductCategories();

    ProductCategory saveOne(ProductCategory productCategory);

    Optional<ProductCategory> findOneById(Long id);

}
