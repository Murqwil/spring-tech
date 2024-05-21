package ru.spring.tech.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.tech.data.CreateUserRequest;
import ru.spring.tech.data.GetAllUserResponse;
import ru.spring.tech.data.UserData;
import ru.spring.tech.exception.UserNotFoundException;

import java.util.List;

// CRUD SERVICE
// C - CREATE - POST
// R - READ - GET
// U - UPDATE - PATCH / PUT (?)
// D - DELETE - DELETE

@RestController
@RequestMapping(value = "/api/v1/")
public interface ApiController {

    @GetMapping(value = "/hello-world")
    ResponseEntity<String> helloWorld();

    @PostMapping(value = "/create-user",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserData> createUser(@RequestBody CreateUserRequest request);

    @GetMapping(value = "/get-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserData> getUserById(@PathVariable Long id) throws UserNotFoundException;

    @DeleteMapping(value = "/delete-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserData> deleteUserById(@PathVariable Long id) throws UserNotFoundException;

    @GetMapping(value = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetAllUserResponse> getAll();
}
