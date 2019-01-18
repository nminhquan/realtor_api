package com.squirrel.realtor.api.service.house;

import com.squirrel.realtor.api.dao.house.HouseDAO;
import com.squirrel.realtor.api.dao.house.mongo.HouseMongoRepository;
import com.squirrel.realtor.api.model.dto.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HouseMongoRepository houseMongoRepository;

    @Autowired
    HouseDAO houseDAO;

    @Override
    public House addAHouse(@ModelAttribute House s) {
        return houseMongoRepository.save(s);
    }

    @Override
    public Optional<House> getHouseById(String id) {
        return houseMongoRepository.findById(id);
    }

    @Override
    public List<House> getAllHouses() {
        return houseMongoRepository.findAll();
    }

    @Override
    public List<House> getHouseByAddress(String address) {
        return houseMongoRepository.findByAddress(address);
    }

    @Override
    public List<House> getNearbyHouses(String address) {
        return houseDAO.searchNearByHouse(address);
    }

    @Override
    public void removeHouse(String id) {
        houseMongoRepository.deleteById(id);
    }

    @Override
    public House updateHouseAddress(String id, String address) {
        House h = houseMongoRepository.findById(id).get();
        h.setAddress(address);
        return houseMongoRepository.save(h);
    }

}
