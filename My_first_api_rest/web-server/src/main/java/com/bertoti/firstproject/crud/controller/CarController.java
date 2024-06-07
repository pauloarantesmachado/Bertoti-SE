package com.bertoti.firstproject.crud.controller;

import com.bertoti.firstproject.crud.model.Car;
import com.bertoti.firstproject.crud.model.DateCar;
import com.bertoti.firstproject.crud.model.UpdateCar;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://127.0.0.1:5501") 
public class CarController {

    private Map<Integer, Car> cars = new Hashtable<>();

    private static Integer id = 0 ;

    @GetMapping
    public List<Car> CarListCar(){
        List<Car> carList = new ArrayList<>();
        for(Car value : cars.values()) {
            carList.add(value);
        }
        return carList;
    }

    @PostMapping
    public void addCar(@RequestBody DateCar car){
        this.id++;
        var model = new Car(car);
        model.setId(this.id);
        cars.put(id, model);

    }

    @PutMapping
    public void updateCar(@RequestBody UpdateCar car){
        var carUpdate = new Car(car);
        var carForUpdate = cars.get(car.id());
        carForUpdate.setName(carUpdate.getName());
        carForUpdate.setYear(carUpdate.getYear());
        carForUpdate.setColor(carUpdate.getColor());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        cars.remove(id);
    }

}
