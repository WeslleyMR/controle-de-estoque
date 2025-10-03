package com.consumoApi.service;

import com.consumoApi.repository.MovementsRepository;
import com.consumoApi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementsServices {
    public MovementsRepository movementsRepository;

    public MovementsServices(MovementsRepository movementsRepository) {
        this.movementsRepository = movementsRepository;
    }

    @Autowired
    private ProductsRepository productsRepository;

    
}
