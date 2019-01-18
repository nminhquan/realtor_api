package com.squirrel.realtor.api.service.search;

import com.squirrel.realtor.api.dao.house.HouseDAO;
import com.squirrel.realtor.api.dao.house.mongo.HouseMongoRepository;
import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.model.dto.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    HouseDAO houseDAO;

    @Autowired
    HouseMongoRepository houseMongoRepository;

    @Override
    public List<House> searchHouseByAddress(String address) {
        return houseDAO.searchNearByHouse(address);
    }

    @Override
    public List<House> searchNearByHouse(Double lat, Double lon, Double distance) {
        houseMongoRepository.findByLocationNear(new Point(lat, lon), new Distance(distance, Metrics.KILOMETERS));
        return null;
    }


}
