package com.bertoti.firstproject.crud.controller;

import com.bertoti.firstproject.crud.model.Car;
import com.bertoti.firstproject.crud.model.CarRepository;
import com.bertoti.firstproject.crud.model.dto.DateCar;
import com.bertoti.firstproject.crud.model.dto.UpdateCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://127.0.0.1:5501") 
public class CarController {

    @Autowired
    CarRepository carRepository;


    @GetMapping
    public List<Car> CarListCar(){
        return carRepository.findAll();
    }

    @PostMapping
    public void addCar(@RequestBody DateCar car){
        var newCar = new Car(car);
        carRepository.save(newCar);
    }

    @PutMapping
    public void updateCar(@RequestBody UpdateCar car){
        var carForUpdate = carRepository.findById(car.id()).orElseThrow();
        carForUpdate.setYear(car.year());
        carForUpdate.setName(car.name());
        carForUpdate.setColor(car.color());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        carRepository.deleteById(id);
    }

}
