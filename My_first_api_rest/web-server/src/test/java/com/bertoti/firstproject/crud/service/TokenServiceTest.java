package com.bertoti.firstproject.crud.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bertoti.firstproject.crud.domain.DataCreateUserDTO;
import com.bertoti.firstproject.crud.domain.UserProfile;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @Autowired
    EntityManager em;

    @Mock
    private UserProfile userProfile;

    @InjectMocks
    private TokenService tokenService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateToken() {
        when(userProfile.getEmail()).thenReturn("user@example.com");

        String token = tokenService.generateToken(userProfile);

        assertNotNull(token);
        assertDoesNotThrow(() -> JWT.require(Algorithm.HMAC256("123"))
                .withIssuer("API Bertoti")
                .build()
                .verify(token));

    }

    private UserProfile createUser(DataCreateUserDTO data){
        var newUser = new UserProfile();
        newUser.setEmail(data.email());
        newUser.setPassword(new BCryptPasswordEncoder().encode(data.password()));
        newUser.setCpf(data.cpf());
        newUser.setPhoneNumber(data.phoneNumber());
        this.em.persist(newUser);
        return newUser;
    }

}