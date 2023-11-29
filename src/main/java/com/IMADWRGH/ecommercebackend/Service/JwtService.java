package com.IMADWRGH.ecommercebackend.Service;

import com.IMADWRGH.ecommercebackend.model.LocalUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
   ///The HMAC is used in JWT to form a Json Web Signature (JWS) RFC 7515 to provide message integrity for a JWT token.
   /// I don't use secret key :) ,I use HMAC algorithm which only needs a special string to decode and encode
    @Value("${jwt.algorithm.key}")
    private String key;


    /// issuer: when we have a Jwt we accompany it with an issuer  || to verifying that we are who gave|send Jwt
    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;
    private static final String USERNAME_KEY="USERNAME";

    @PostConstruct
    public void postConstruct(){
        algorithm=Algorithm.HMAC256(key);
    }

    public String generateJwt(LocalUser user){
        return JWT.create()
                .withClaim(USERNAME_KEY,user.getUserName())
                .withExpiresAt(new Date(System.currentTimeMillis()+(1000L *expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String GetUsername(String token){
     return  JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }
}
