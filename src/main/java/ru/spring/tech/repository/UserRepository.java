package ru.spring.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spring.tech.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByDeletedAtIsNull();
}
