package com.squirrel.realtor.api.model.dto;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "house")
public class House {
    @Id
    private String houseId;

    @Indexed
    private String address;
    private String ownerName;
    private String builderName;
    private int bedrooms;
    private int bathrooms;
    private float sqft;
    private String agentId;
    private Location location;
}
