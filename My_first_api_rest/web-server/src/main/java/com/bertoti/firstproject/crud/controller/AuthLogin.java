package com.bertoti.firstproject.crud.controller;

import com.bertoti.firstproject.crud.domain.DataLoginDTO;
import com.bertoti.firstproject.crud.domain.TokenDTO;
import com.bertoti.firstproject.crud.domain.UserProfile;
import com.bertoti.firstproject.crud.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthLogin {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity login(@RequestBody DataLoginDTO data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = authenticationManager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((UserProfile) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }
}
