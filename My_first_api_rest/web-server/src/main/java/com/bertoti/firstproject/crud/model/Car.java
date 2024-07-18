package com.bertoti.firstproject.crud.model;

import com.bertoti.firstproject.crud.model.dto.DateCar;
import com.bertoti.firstproject.crud.model.dto.UpdateCar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(name = "create_year")
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