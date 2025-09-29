package com.consumoApi.controller;

import com.consumoApi.entities.Products;
import com.consumoApi.service.ProductsServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {
    private ProductsServices productsServices;

    public ProductsController(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    @PostMapping
    public void saveProducts(@RequestBody Products products){
        productsServices.saveProducts(products);
    }

    @GetMapping
    public List<Products> searchAllProducts(){
        return productsServices.searchByName();
    }

    @GetMapping("{id}")
    public Products searchProductsById(@PathVariable Integer id){
        return productsServices.searchById(id);
    }
}
