package com.schedulingproject.project.product.service.impl;

import com.schedulingproject.project.product.model.ProductCategory;
import com.schedulingproject.project.product.repository.ProductCategoryRepository;
import com.schedulingproject.project.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory saveOne(ProductCategory productCategory) {
        return productCategoryRepository.saveAndFlush(productCategory);
    }

    @Override
    public Optional<ProductCategory> findOneById(Long id) {
        return productCategoryRepository.findById(id);
    }
}
