package com.nhnacademy.springjpa.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UserModifyRequest {
    @Length(min = 3, max = 20)
    @NotBlank
    private String password;

    @Min(1)
    @Max(100)
    private int age;

}
