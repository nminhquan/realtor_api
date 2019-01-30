package com.squirrel.realtor.api.service.house;

import com.squirrel.realtor.api.dto.mysql.House;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    House addAHouse(House s);
    Optional<House> getHouseById(long id);
    List<House> getAllHouses();
    List<House> getNearbyHouses(String address);
    void removeHouse(long id);
    House updateHouseAddress(long id, String address);
}
