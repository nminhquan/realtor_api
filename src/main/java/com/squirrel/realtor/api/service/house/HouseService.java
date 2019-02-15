package com.squirrel.realtor.api.service.house;

import com.squirrel.realtor.api.model.dto.House;

import java.util.List;

public interface HouseService {
    House addAHouse(House s);
    List<House> getHouseByAddress(String address);
    List<House> getNearbyHouses(double lat, double lng, double distance);
}
