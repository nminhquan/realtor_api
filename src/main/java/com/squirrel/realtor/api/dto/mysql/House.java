package com.squirrel.realtor.api.dto.mysql;

import com.squirrel.realtor.api.dto.Location;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long houseId;

    private String address;
    private String ownerName;
    private String builderName;
    private int bedrooms;
    private int bathrooms;
    private double sqft;
    private double price;
    private String agentId;
    private Location location;
    private double latitude;
    private double longitude;
}
