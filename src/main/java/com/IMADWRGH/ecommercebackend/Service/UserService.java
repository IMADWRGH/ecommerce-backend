package com.IMADWRGH.ecommercebackend.Service;

import com.IMADWRGH.ecommercebackend.Controller.Model.LoginBody;
import com.IMADWRGH.ecommercebackend.Controller.Model.RegistrationBody;
import com.IMADWRGH.ecommercebackend.Exception.UserException;
import com.IMADWRGH.ecommercebackend.Repository.UserRepository;
import com.IMADWRGH.ecommercebackend.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EncryptionService encryptionService;
    private final JwtService jwtService;
    @Autowired
    public UserService(UserRepository userRepository, EncryptionService encryptionService, JwtService jwtService) {
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }

    public void Register(RegistrationBody registrationBody) throws UserException {
        if (userRepository.findByUserNameIgnoreCase(registrationBody.getUsername()).isPresent()
                || userRepository.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()) {
           throw new UserException();
        }
        LocalUser localUser = new LocalUser();
        localUser.setFullName(registrationBody.getFullname());
        localUser.setEmail(registrationBody.getEmail());
        localUser.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        localUser.setUserName(registrationBody.getUsername());
        userRepository.save(localUser);
    }

    public String Login(LoginBody loginBody){
        Optional<LocalUser> optionalUser=userRepository.findByUserNameIgnoreCase(loginBody.getUsername());
        if (optionalUser.isPresent()){
            LocalUser User= optionalUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), User.getPassword())) {
                return jwtService.generateJwt(User);
            }
        }
        return null;
    }
}
