package com.IMADWRGH.ecommercebackend.Controller.Security;

import com.IMADWRGH.ecommercebackend.Repository.UserRepository;
import com.IMADWRGH.ecommercebackend.Service.JwtService;
import com.IMADWRGH.ecommercebackend.model.LocalUser;
import com.auth0.jwt.exceptions.JWTDecodeException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    @Autowired
    public JwtRequestFilter(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String tokenHeader= request.getHeader("Authorization");
    if (tokenHeader!=null && tokenHeader.startsWith("Bearer ")){
        String token=tokenHeader.substring(7);
        try{
        String username= jwtService.GetUsername(token);
        Optional<LocalUser> optionalLocalUser= userRepository.findByUserNameIgnoreCase(username);
        if (optionalLocalUser.isPresent()){
            LocalUser user= optionalLocalUser.get();
            UsernamePasswordAuthenticationToken authentication
                    =new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        }catch (JWTDecodeException ignored) {
        }
    }
        filterChain.doFilter(request, response);
    }
}
