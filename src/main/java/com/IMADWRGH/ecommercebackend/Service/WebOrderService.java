package com.IMADWRGH.ecommercebackend.Service;

import com.IMADWRGH.ecommercebackend.Repository.WebOrderRepository;
import com.IMADWRGH.ecommercebackend.model.LocalUser;
import com.IMADWRGH.ecommercebackend.model.WebOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebOrderService {
    private final WebOrderRepository webOrderRepository;

    @Autowired
    public WebOrderService(WebOrderRepository webOrderRepository) {
        this.webOrderRepository = webOrderRepository;
    }




    public List<WebOrder> getOrder(LocalUser user){
        return webOrderRepository.findByUser(user);
    }
}
