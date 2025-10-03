package com.consumoApi.controller;

import com.consumoApi.entities.Suppliers;
import com.consumoApi.repository.SuppliersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    private final SuppliersRepository repository;

    public SuppliersController(SuppliersRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Suppliers> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Suppliers getById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Suppliers create(@RequestBody Suppliers suppliers) {
        return repository.save(suppliers);
    }

    @PutMapping("/{id}")
    public Suppliers update(@PathVariable Integer id, @RequestBody Suppliers suppliers) {
        suppliers.setId(id);
        return repository.save(suppliers);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
