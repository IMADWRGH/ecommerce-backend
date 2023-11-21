package com.IMADWRGH.ecommercebackend.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class Authentication {

    @PostMapping(path = "/register")
    public void RegisterUser(@RequestBody RegistrationBody registrationBody){

    }
}
