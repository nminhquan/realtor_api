package com.squirrel.realtor.api.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "house")
public class House {
    @Id
    private String houseId;

    @TextIndexed
    private String address;

    @TextIndexed
    private String ownerName;

    @TextIndexed
    private String builderName;
    private int bedrooms;
    private int bathrooms;
    private double sqft;
    private double price;
    private String agentId;
    private Location location;
}
