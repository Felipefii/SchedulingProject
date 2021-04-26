package com.schedulingproject.project.product.service;

import com.schedulingproject.project.product.dto.ProductDTO;
import com.schedulingproject.project.product.model.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveOne(Product product);

    Optional<Product> findOneById(Long id);
}
