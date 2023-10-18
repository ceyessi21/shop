package com.talan.boutique0.controllers;

import com.talan.boutique0.models.Product;
import com.talan.boutique0.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listET")
    public List<Product> getAllProductStartByET() {
        return productService.getAllProductStartByET();
    }

    @DeleteMapping("/deleteById")
    public void deleteAllByIds(@RequestBody List<Long> ids){
        productService.deleteAllByIds(ids);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product p){
        return productService.createProduct(p);
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/list")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){
        return productService.getAllCategories();
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product p){
        return productService.updateProduct(p);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
