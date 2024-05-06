package ru.sermyazhko.mingas.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String position;
}
