package com.schedulingproject.project.product.controller;

import com.schedulingproject.project.exception.error.HomeNotFoundException;
import com.schedulingproject.project.product.dto.ProductCategoryDTO;
import com.schedulingproject.project.product.model.ProductCategory;
import com.schedulingproject.project.product.service.ProductCategoryService;
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
@RequestMapping("/categories")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ProductService productService;

    @ApiOperation(value = "Returns a list of all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a list of all categories"),
            @ApiResponse(code = 404, message = "Returns a empty list")
    })
    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories(){
        List<ProductCategory> categories = productCategoryService.getAllProductCategories();
        if (categories.isEmpty()) {
            throw new HomeNotFoundException("No categories founded: ");
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @ApiOperation(value = "Save and returns the saved category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Save and returns the saved category")
    })
    @PostMapping
    public ResponseEntity<ProductCategory> insertProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO){
        ProductCategory category = new ProductCategory().of(productCategoryDTO);

        category = productCategoryService.saveOne(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Find and return a category searching by id")
    @ApiResponses(value  = {
            @ApiResponse(code = 200, message = "Find and return a category searching by id"),
            @ApiResponse(code = 404, message = "category not found")
    })
    @GetMapping("/category/{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable Long id){
        Optional<ProductCategory> category = productCategoryService.findOneById(id);
        if (!category.isPresent()) {
            throw new HomeNotFoundException("Category not found with id: " + id);
        }
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }

}
