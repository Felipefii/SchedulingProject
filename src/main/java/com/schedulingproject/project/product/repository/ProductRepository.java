package com.schedulingproject.project.product.repository;

import com.schedulingproject.project.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
