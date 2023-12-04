package com.IMADWRGH.ecommercebackend.Controller.ApiAuth;

import com.IMADWRGH.ecommercebackend.Controller.Model.LoginBody;
import com.IMADWRGH.ecommercebackend.Controller.Model.LoginResponse;
import com.IMADWRGH.ecommercebackend.Controller.Model.RegistrationBody;
import com.IMADWRGH.ecommercebackend.Exception.UserException;
import com.IMADWRGH.ecommercebackend.Service.UserService;
import com.IMADWRGH.ecommercebackend.model.LocalUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public ResponseEntity<Void> RegisterUser(@Valid @RequestBody RegistrationBody registrationBody)  {
        try {
            userService.Register(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponse> LoginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.Login(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }


    @GetMapping(path = "/profile")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user){
        return user;
    }

}
