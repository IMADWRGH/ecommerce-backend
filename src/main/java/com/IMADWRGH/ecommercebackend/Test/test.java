package com.IMADWRGH.ecommercebackend.Test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class test {
    @Id
    private int id;
    @Column
    private String username;
}
