package com.squirrel.realtor.api.service.house;

import com.squirrel.realtor.api.model.dto.House;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    House addAHouse(House s);
    Optional<House> getHouseById(String id);
    List<House> getAllHouses();
    List<House> getHouseByAddress(String address);
    List<House> getNearbyHouses(String address);
    void removeHouse(String id);
    House updateHouseAddress(String id, String address);
}
