package com.bertoti.firstproject.crud.domain;

public record DataCreateUserDTO(
         String email,
         String password,
         String cpf,
         String phoneNumber
) {
}
