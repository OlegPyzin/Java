package com.example.study.model.dto.request;

import com.example.study.model.enums.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CarInfoRequest {
    String modelName;
    String modelVIN;
    Float  weight;
    Color  color;
    Date   dateMade;
    Date   dateSold;
    Vendor vendor;
    BigDecimal price;
    String regNumber;
}
