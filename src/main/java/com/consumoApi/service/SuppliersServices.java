package com.consumoApi.service;

import com.consumoApi.entities.Suppliers;
import com.consumoApi.entities.Users;
import com.consumoApi.repository.SuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersServices {
    public SuppliersRepository suppliersRepository;

    public SuppliersServices(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    public void saveSuppliers(Suppliers suppliers){
        suppliersRepository.save(suppliers);
    }

    public Suppliers searchById(Integer id){
        return suppliersRepository.findById(id).orElse(null);
    }

    public List<Suppliers> searchByName(){
        return suppliersRepository.findAll();
    }

    public void deleteSuppliers(Integer id){
        suppliersRepository.deleteById(id);
    }

    public Suppliers updateSuppliers(Integer id, Suppliers suppliers){
        Suppliers existingSuppliers = suppliersRepository.findById(id).orElse(null);
        if(existingSuppliers != null){
            existingSuppliers.setName(suppliers.getName());
            return suppliersRepository.save(existingSuppliers);
        }
        return null;
    }
}
