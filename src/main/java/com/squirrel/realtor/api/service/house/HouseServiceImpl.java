package com.squirrel.realtor.api.service.house;

import com.squirrel.realtor.api.dao.house.HouseDAO;
import com.squirrel.realtor.api.dao.house.HouseRepository;
import com.squirrel.realtor.api.model.dto.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;

    @Autowired
    HouseDAO houseDAO;

    @Override
    public House addAHouse(@ModelAttribute House s) {
        return houseRepository.save(s);
    }

    @Override
    public List<House> getHouseByAddress(String address) {
        return houseRepository.findByAddress(address);
    }

    @Override
    public List<House> getNearbyHouses(double lat, double lng, double distance) {
        return houseDAO.searchNearByHouse(lat, lng, distance);
    }

}
