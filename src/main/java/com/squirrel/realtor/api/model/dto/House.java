package com.squirrel.realtor.api.model.dto;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @ToString
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="House")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long houseId;
    private @NonNull  String address;
    private String ownerName;
    private String builderName;
    private int bedrooms;
    private int bathrooms;
    private double latitude;
    private double longitude;
    private double price;
    private float sqft;
}
