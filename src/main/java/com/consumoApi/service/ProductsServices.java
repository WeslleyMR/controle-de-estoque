package com.consumoApi.service;

import com.consumoApi.entities.Products;
import com.consumoApi.entities.Suppliers;
import com.consumoApi.entities.Users;
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

    public void deleteProducts(Integer id){
        productsRepository.deleteById(id);
    }

    public Products updateProducts(Integer id, Products products){
        Products existingProducs = productsRepository.findById(id).orElse(null);
        if(existingProducs != null){
            existingProducs.setName(products.getName());
            return productsRepository.save(existingProducs);
        }
        return null;
    }
}
