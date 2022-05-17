package com.nhnacademy.springjpa.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterRequest {
    String id;

    @NotBlank
    String password;

    @NotNull
    int age;

}
