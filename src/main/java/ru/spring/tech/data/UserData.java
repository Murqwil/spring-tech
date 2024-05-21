package ru.spring.tech.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Builder
public class UserData {
    public Long id;
    public String firstName;
    public String middleName;
    public String lastName;
    public String userName;
    public Short age;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
