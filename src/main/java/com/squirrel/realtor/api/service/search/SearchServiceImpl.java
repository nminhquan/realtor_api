package com.squirrel.realtor.api.service.search;

import com.squirrel.realtor.api.dao.house.HouseDAO;
import com.squirrel.realtor.api.dao.house.HouseRepository;
import com.squirrel.realtor.api.model.dto.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    HouseDAO houseDAO;

    @Override
    public List<House> searchHouseByAddress(String address) {
        return houseDAO.searchNearByHouse(address);
    }
}
