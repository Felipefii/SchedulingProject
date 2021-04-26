package com.schedulingproject.project.product.repository;

import com.schedulingproject.project.product.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
