package com.IMADWRGH.ecommercebackend.Controller;

import com.IMADWRGH.ecommercebackend.Exception.UserException;
import com.IMADWRGH.ecommercebackend.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class Authentication {
    private final UserService userService;
    @Autowired
    public Authentication(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity RegisterUser(@Valid @RequestBody RegistrationBody registrationBody)  {
        try {
            userService.Register(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
