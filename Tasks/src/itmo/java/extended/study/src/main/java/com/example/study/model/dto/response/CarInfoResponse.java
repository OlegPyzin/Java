package com.example.study.model.dto.response;

import com.example.study.model.dto.request.CarInfoRequest;
import com.example.study.model.dto.request.ClientInfoRequest;
import com.example.study.model.enums.CarStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CarInfoResponse extends CarInfoRequest {
    Long id;
    CarStatus status;
}
