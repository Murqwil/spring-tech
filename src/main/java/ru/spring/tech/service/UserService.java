package ru.spring.tech.service;

import ru.spring.tech.data.CreateUserRequest;
import ru.spring.tech.data.GetAllUserResponse;
import ru.spring.tech.data.UserData;
import ru.spring.tech.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    UserData createUser(CreateUserRequest request);
    UserData getUserById(Long id) throws UserNotFoundException;

    UserData deleteUserById(Long id) throws UserNotFoundException;

    GetAllUserResponse getAll();
}
