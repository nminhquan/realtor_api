package com.squirrel.realtor.api.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    Double[] coordinates;
    String type;
}
