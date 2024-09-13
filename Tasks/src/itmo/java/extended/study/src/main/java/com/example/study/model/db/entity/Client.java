package com.example.study.model.db.entity;

import com.example.study.model.enums.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "clients")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "middle_name")
    String middleName;

    @Column(name = "email")
    String email;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "password")
    String password;

    @Column(name = "age")
    Integer age;

    @Column(name = "gender", columnDefinition = "VARCHAR(6)")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "added_at")
    LocalDateTime addedAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @Column(name = "status")
    ClientStatus status;

    @OneToMany
    List<Car> cars;
}
