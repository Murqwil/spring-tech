package ru.spring.tech.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllUserResponse {
    private Integer count;
    private List<UserData> users;
}
