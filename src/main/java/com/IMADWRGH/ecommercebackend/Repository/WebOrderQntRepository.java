package com.IMADWRGH.ecommercebackend.Repository;

import com.IMADWRGH.ecommercebackend.model.WebOrderQuantities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebOrderQntRepository extends JpaRepository<WebOrderQuantities,Long> {
}
