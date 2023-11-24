package com.IMADWRGH.ecommercebackend.Controller;

import jakarta.validation.constraints.*;

public class RegistrationBody {
    @NotNull
    @NotBlank
    @Size(max = 212,min = 3)
    private String username;
    @NotNull
    @NotBlank
    private String fullname;
    @NotNull
    @Email
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 25,min = 8)
//            (?=.*\d)                //should contain at least one digit
//            (?=.*[a-z])             //should contain at least one lower case
//            (?=.*[A-Z])             //should contain at least one upper case
//            [a-zA-Z0-9]{8,}         //should contain at least 8 from the mentioned characters
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{8,}$")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
