package com.schedulingproject.project.product.service.impl;

import com.schedulingproject.project.product.dto.ProductDTO;
import com.schedulingproject.project.product.model.Product;
import com.schedulingproject.project.product.repository.ProductRepository;
import com.schedulingproject.project.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOne(ProductDTO productDTO) {
        Product product = new Product().of(productDTO);
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Optional<Product> findOneById(Long id) {
        return productRepository.findById(id);
    }
}
