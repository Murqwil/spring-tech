package ru.spring.tech.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.spring.tech.data.UserData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TEST_USER")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "AGE")
    private Short age;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;


    public static UserData from(UserEntity entity) {
        return UserData.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .firstName(entity.getFirstName())
                .age(entity.getAge())
                .createdAt(entity.createdAt)
                .deletedAt(entity.deletedAt)
                .build();
    }
}
