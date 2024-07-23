package com.bertoti.firstproject.crud.model;

import com.bertoti.firstproject.crud.domain.DataCreateUserDTO;
import com.bertoti.firstproject.crud.domain.UserProfile;
import com.bertoti.firstproject.crud.domain.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class CarRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Should get user successfully from DB")
    void findUserByEmailSuccess() throws Exception {
        DataCreateUserDTO data = new DataCreateUserDTO("test@.com", "test", "999999999", "1212121212");
        var user = this.createUSer(data);
        Optional<UserProfile> foundUser = this.userRepository.findByEmail(user.getEmail());

        assertThat(foundUser.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get user from DB when user not exists")
    void findUserByEmailError() throws Exception {
        DataCreateUserDTO data = new DataCreateUserDTO("test@.com", "test", "999999999", "1212121212");
        Optional<UserProfile> foundUser = this.userRepository.findByEmail(data.email());

        assertThat(foundUser.isEmpty()).isTrue();
    }

    private UserProfile createUSer(DataCreateUserDTO data){
        var newUser = new UserProfile();
        newUser.setEmail(data.email());
        newUser.setPassword(new BCryptPasswordEncoder().encode(data.password()));
        newUser.setCpf(data.cpf());
        newUser.setPhoneNumber(data.phoneNumber());
        this.em.persist(newUser);
        return newUser;
    }


}