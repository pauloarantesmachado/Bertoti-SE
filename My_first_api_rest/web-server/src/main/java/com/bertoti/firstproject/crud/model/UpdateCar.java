package com.bertoti.firstproject.crud.model;

public record UpdateCar(
        Integer id,
        String name,
        Integer year,
        String color
) {
}
