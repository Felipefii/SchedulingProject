package com.schedulingproject.project.product.controller;

import com.schedulingproject.project.exception.error.HomeNotFoundException;
import com.schedulingproject.project.product.dto.ProductDTO;
import com.schedulingproject.project.product.model.Product;
import com.schedulingproject.project.product.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation(value = "Returns a list of all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a list of all products"),
            @ApiResponse(code = 404, message = "Returns a empty list")
    })
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            throw new HomeNotFoundException("No products founded: ");
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @ApiOperation(value = "Save and returns the saved product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Save and returns the saved product")
    })
    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody ProductDTO productDTO){
        Product product = productService.saveOne(productDTO);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Find and return a product searching by id")
    @ApiResponses(value  = {
            @ApiResponse(code = 200, message = "Find and return a product searching by id"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.findOneById(id);
        if (!product.isPresent()) {
            throw new HomeNotFoundException("Product not found with id: " + id);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
}
