package com.IMADWRGH.ecommercebackend.Service;

import com.IMADWRGH.ecommercebackend.Controller.RegistrationBody;
import com.IMADWRGH.ecommercebackend.Exception.UserException;
import com.IMADWRGH.ecommercebackend.Repository.UserRepository;
import com.IMADWRGH.ecommercebackend.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void Register(RegistrationBody registrationBody) throws UserException {
        if (userRepository.findByUserNameIgnoreCase(registrationBody.getUsername()).isPresent()
                || userRepository.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()) {
           throw new UserException();
        }
        LocalUser localUser = new LocalUser();
        localUser.setFullName(registrationBody.getFullname());
        localUser.setEmail(registrationBody.getEmail());
        localUser.setPassword(registrationBody.getPassword());
        localUser.setUserName(registrationBody.getUsername());
        userRepository.save(localUser);
    }
}
