package ru.spring.tech.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.tech.data.CreateUserRequest;
import ru.spring.tech.data.GetAllUserResponse;
import ru.spring.tech.data.UserData;
import ru.spring.tech.entity.UserEntity;
import ru.spring.tech.exception.UserNotFoundException;
import ru.spring.tech.repository.UserRepository;
import ru.spring.tech.service.UserService;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserData createUser(CreateUserRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .age(request.getAge())
                .createdAt(LocalDateTime.now())
                .build();
        UserEntity save = userRepository.save(userEntity);
        return UserEntity.from(save);
    }

    @Override
    public UserData getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .map(UserEntity::from)
                .orElseThrow(() ->
                        new UserNotFoundException(MessageFormat.format("Пользователь с id = {0} не найден!", id)));
    }

    @Override
    public UserData deleteUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .map(it -> {
                    it.setDeletedAt(LocalDateTime.now());
                    UserEntity save = userRepository.save(it);
                    return UserEntity.from(save);
                }).orElseThrow(() -> new UserNotFoundException("Пользователь для удаление с id = {0} не найден!"));
    }

    @Override
    public GetAllUserResponse getAll() {
        List<UserEntity> allUsers = userRepository.findAllByDeletedAtIsNull();
        return GetAllUserResponse.builder()
                .count(allUsers.size())
                .users(allUsers.stream().map(UserEntity::from).collect(Collectors.toList()))
                .build();
    }
}
