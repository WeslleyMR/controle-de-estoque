package com.consumoApi.entities;

import jakarta.persistence.*;
import org.hibernate.service.spi.InjectService;

@Entity
@Table(name = "users")
public class Users {
    public Users() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(name= "user_email", nullable = false, length = 100)
    private String email;

    @Column(name="user_password", nullable = false, length = 100)
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
