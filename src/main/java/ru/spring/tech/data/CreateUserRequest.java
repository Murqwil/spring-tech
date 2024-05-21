package ru.spring.tech.data;

import lombok.Data;

@Data
public class CreateUserRequest {
    public String firstName;
    public String middleName;
    public String lastName;
    public String userName;
    public Short age;
}
