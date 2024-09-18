package com.example.study.model.dto.request;

import com.example.study.model.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientInfoRequest {
    String lastName;
    String firstName;
    String middleName;
    String email;
    String phone;
    String address;
    String password;
    Integer age;
    Gender gender;
}
