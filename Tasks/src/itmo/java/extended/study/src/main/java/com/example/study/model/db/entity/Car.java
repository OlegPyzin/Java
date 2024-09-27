package com.example.study.model.db.entity;

import com.example.study.model.enums.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "cars")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "model_name")
    String modelName;

    @Column(name = "model_vin")
    String modelVIN;

    @Column(name = "weight")
    Float weight;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    Color color;

    @Column(name = "date_made")
    Date dateMade;

    @Column(name = "date_sold")
    Date dateSold;

    @Column(name = "vendor")
    @Enumerated(EnumType.STRING)
    Vendor vendor;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "reg_number")
    String regNumber;

    @Column(name = "added_at")
    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime addedAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime updatedAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    CarStatus status;

    @ManyToOne
    @JsonBackReference(value = "driver_cars")
    Client client;
}
