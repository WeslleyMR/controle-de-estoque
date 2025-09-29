package com.consumoApi.service;

import com.consumoApi.entities.Products;
import com.consumoApi.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServices {
    private ProductsRepository productsRepository;

    public ProductsServices(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void saveProducts(Products products){
        productsRepository.save(products);
    }

    public Products searchById(Integer id){
        return productsRepository.findById(id).orElse(null);
    }

    public List<Products> searchByName(){
        return productsRepository.findAll();
    }
}
