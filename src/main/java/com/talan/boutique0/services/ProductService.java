package com.talan.boutique0.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talan.boutique0.models.Product;
import com.talan.boutique0.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init(){
        try {
            Resource r = resourceLoader.getResource("classpath:products.json");
            InputStream inputStream = r.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            List<Product> products = objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});
            productRepository.saveAll(products);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file",e);
        }
    }
    public List<Product> getAllProductStartByET(){
        return productRepository.getAllProductStartByET();
    }

    public void deleteAllByIds(List<Long> ids){
        productRepository.deleteAllByIds(ids);
    }

    public List<String> getAllCategories(){
        return productRepository.getAllCategories();
    }

    public Product createProduct(Product p){
        return productRepository.save(p);
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product p){
        return productRepository.save(p);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
