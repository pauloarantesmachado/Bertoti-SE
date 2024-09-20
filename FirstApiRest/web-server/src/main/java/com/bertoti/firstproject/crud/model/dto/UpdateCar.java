package com.bertoti.firstproject.crud.model.dto;

public record UpdateCar(
        Integer id,
        String name,
        Integer year,
        String color
) {
}
