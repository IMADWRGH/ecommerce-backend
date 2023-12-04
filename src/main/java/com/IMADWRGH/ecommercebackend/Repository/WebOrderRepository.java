package com.IMADWRGH.ecommercebackend.Repository;

import com.IMADWRGH.ecommercebackend.model.WebOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebOrderRepository extends JpaRepository<WebOrder,Long> {
}
