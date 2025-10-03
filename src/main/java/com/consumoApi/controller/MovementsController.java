package com.consumoApi.controller;

import com.consumoApi.entities.Movements;
import com.consumoApi.repository.MovementsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementsController {

    private final MovementsRepository repository;

    public MovementsController(MovementsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Movements> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Movements getById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Movements create(@RequestBody Movements movements) {
        return repository.save(movements);
    }

    @PutMapping("/{id}")
    public Movements update(@PathVariable Integer id, @RequestBody Movements movements) {
        movements.setId(id);
        return repository.save(movements);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
