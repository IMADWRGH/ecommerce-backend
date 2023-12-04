package com.IMADWRGH.ecommercebackend.Repository;

import com.IMADWRGH.ecommercebackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
