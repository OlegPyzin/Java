package com.example.study.model.dto.response;

import com.example.study.model.dto.request.ClientInfoRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientInfoResponse extends ClientInfoRequest {
    Long id;
}
