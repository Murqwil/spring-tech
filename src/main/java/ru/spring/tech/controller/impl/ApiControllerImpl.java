package ru.spring.tech.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.tech.controller.ApiController;
import ru.spring.tech.data.CreateUserRequest;
import ru.spring.tech.data.GetAllUserResponse;
import ru.spring.tech.data.UserData;
import ru.spring.tech.exception.UserNotFoundException;
import ru.spring.tech.service.UserService;

@RestController
@RequiredArgsConstructor
public class ApiControllerImpl implements ApiController {

    public final UserService userService;


    @Override
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Hello World!");
    }

    @Override
    public ResponseEntity<UserData> createUser(CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @Override
    public ResponseEntity<UserData> getUserById(Long id) throws UserNotFoundException {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<UserData> deleteUserById(Long id) throws UserNotFoundException {
        return ResponseEntity.ok().body(userService.deleteUserById(id));
    }

    @Override
    public ResponseEntity<GetAllUserResponse> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }

}