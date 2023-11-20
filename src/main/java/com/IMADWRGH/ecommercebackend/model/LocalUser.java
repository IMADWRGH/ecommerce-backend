package com.IMADWRGH.ecommercebackend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "local_user")
public class LocalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "full_name",nullable = false )
    private String fullName;
    @Column(name = "unername",nullable = false ,unique = true)
    private String unerName;
    @Column(name = "email",nullable = false ,length = 320)
    private String email;
    @Column(name = "password",nullable = false ,length = 1000)
    private String password;

    /////////////relationship with Address////
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Address> addresses=new ArrayList<>();

    ////////Getter & Setter//////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUnerName() {
        return unerName;
    }

    public void setUnerName(String unerName) {
        this.unerName = unerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }



}
