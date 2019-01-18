package com.squirrel.realtor.api.model.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    Double[] coordinates;
    String type;
}
