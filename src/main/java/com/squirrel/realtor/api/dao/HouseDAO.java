package com.squirrel.realtor.api.dao;

import com.squirrel.realtor.api.dto.mysql.House;

import java.util.List;

public interface HouseDAO {
    List<House> searchNearByHouse(String address);
    House addNewHouse(House house);
}
