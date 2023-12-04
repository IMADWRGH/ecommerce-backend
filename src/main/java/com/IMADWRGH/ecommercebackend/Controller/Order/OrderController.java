package com.IMADWRGH.ecommercebackend.Controller.Order;

import com.IMADWRGH.ecommercebackend.Service.WebOrderService;
import com.IMADWRGH.ecommercebackend.model.LocalUser;
import com.IMADWRGH.ecommercebackend.model.WebOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final WebOrderService webOrderService;

    @Autowired
    public OrderController(WebOrderService webOrderService) {
        this.webOrderService = webOrderService;
    }

    @GetMapping
    public ResponseEntity<List<WebOrder>> getAllOrder(@AuthenticationPrincipal LocalUser user){
        return new ResponseEntity<>(webOrderService.getOrder(user), HttpStatus.OK);
    }
}
