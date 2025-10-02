package com.consumoApi.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ConditionalOnIssuerLocationJwtDecoder;

import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
public class Movements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_products", nullable = false)
    private Products products;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users users;

    private Integer quantity;

    @Column(name = "movements_date", nullable = false)
    private LocalDateTime movementsDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getMovementsDate() {
        return movementsDate;
    }

    public void setMovementsDate(LocalDateTime movementsDate) {
        this.movementsDate = movementsDate;
    }
}
