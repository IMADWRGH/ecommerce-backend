package com.IMADWRGH.ecommercebackend.Repository;

import com.IMADWRGH.ecommercebackend.model.LocalUser;
import com.IMADWRGH.ecommercebackend.model.WebOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WebOrderRepository extends JpaRepository<WebOrder,Long> {
    List<WebOrder> findByUser(LocalUser user);
}
