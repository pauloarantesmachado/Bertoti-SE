package com.bertoti.firstproject.crud.controller;

import com.bertoti.firstproject.crud.model.Car;
import com.bertoti.firstproject.crud.model.DateCar;
import com.bertoti.firstproject.crud.model.UpdateCar;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {


    private List<Car> cars = new ArrayList<>();

    private static Integer id = 1;


    @GetMapping
    public List<Car> CarListCar(){
        return this.cars;
    }

    @PostMapping
    public void addCar(@RequestBody DateCar car){
        this.id++;
        var model = new Car(car);
        model.setId(this.id);
        cars.add(model);

    }

    @PutMapping
    public void updateCar(@RequestBody UpdateCar car){
        var carUpdate = new Car(car);
        for (Car value:  cars){
            if(value.getId() == car.id()){
                value.setName(car.name());
                value.setColor(car.color());
                value.setYear(car.year());
            }
        }

    }

}
