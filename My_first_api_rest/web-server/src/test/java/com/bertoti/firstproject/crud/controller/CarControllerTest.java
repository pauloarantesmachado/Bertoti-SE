package com.bertoti.firstproject.crud.controller;

import com.bertoti.firstproject.crud.domain.UserRepository;
import com.bertoti.firstproject.crud.model.Car;
import com.bertoti.firstproject.crud.model.CarRepository;
import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class CarControllerTest {

    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should return the car list not empty")
    public void findAllTest() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(1,"Ferrari",1998,"black");
        Car car2 = new Car(2,"Celta",1998,"black");
        cars.add(car1);
        cars.add(car2);
        when(carRepository.findAll()).thenReturn(cars);
        Collection<Car> result = carRepository.findAll();
        assertTrue(!result.isEmpty());
    }


    @Test
    @DisplayName("Should created the car in dataBase")
    public void createCarTest() {
        Car car = new Car(1,"Ferrari",1998,"black");
        when(carRepository.save(car)).thenReturn(car);
        Car result = carRepository.save(car);
        assertEquals(result.getId(),car.getId());
    }

}