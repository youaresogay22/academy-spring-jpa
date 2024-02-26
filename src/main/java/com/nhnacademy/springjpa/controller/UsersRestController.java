package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.UserRegisterRequest;
import com.nhnacademy.springjpa.entity.User;
import com.nhnacademy.springjpa.exception.ValidationFailedException;
import com.nhnacademy.springjpa.service.UserService;
import com.nhnacademy.springjpa.validator.UserRegisterRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersRestController {
    private final UserRegisterRequestValidator validator;
    private final UserService userService;

    public UsersRestController(UserRegisterRequestValidator validator, UserService userService) {
        this.validator = validator;
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User createUser(@Valid @RequestBody UserRegisterRequest userRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        return userService.createUser(userRequest.getId(), userRequest.getPassword());
    }

    @InitBinder("userRegisterRequest")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

}
