package com.bertoti.firstproject.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Integer id;

    private String name;

    private Integer year;

    private String color;


    public Car(DateCar car) {
        this.name = car.name();
        this.year = car.year();
        this.color = car.color();
    }

    public Car(UpdateCar car) {
        this.id = car.id();
        this.name = car.name();
        this.year = car.year();
        this.color = car.color();
    }

}