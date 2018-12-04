package com.squirrel.realtor.api.model.dto.RowMapper;

import com.squirrel.realtor.api.model.dto.House;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseRowMapper implements RowMapper<House> {

    @Override
    public House mapRow(ResultSet resultSet, int i) throws SQLException {
        House house = new House();
        house.setAddress(resultSet.getString("address"));
        house.setBathrooms(resultSet.getInt("bathrooms"));
        house.setBedrooms(resultSet.getInt("bedrooms"));
        house.setBuilderName(resultSet.getString("builderName"));
        house.setOwnerName(resultSet.getString("ownerName"));
        house.setHouseId(resultSet.getLong("houseId"));
        house.setSqft(resultSet.getFloat("sqft"));
        return house;
    }
}
