package com.squirrel.realtor.api.dao.house;

import com.squirrel.realtor.api.model.dto.House;

import java.util.List;

public interface HouseDAO {
    List<House> searchNearByHouse(String address);
}
