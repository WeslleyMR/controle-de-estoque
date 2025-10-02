package com.consumoApi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "suppliers_name", nullable = false, length = 100)
    private String name;

    @Column(name = "suppliers_cnpj", nullable = false, length = 18)
    private String cnpj;

    @Column(name = "suppliers_tel", nullable = false, length = 20)
    private String tel;

    @Column(name = "suppliers_email", nullable = false, length = 100)
    private String email;

    @Column(name = "suppliers_address", nullable = false, length = 200)
    private String address;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
