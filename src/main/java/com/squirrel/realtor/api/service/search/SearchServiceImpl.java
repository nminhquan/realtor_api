package com.squirrel.realtor.api.service.search;

import com.squirrel.realtor.api.dao.HouseRepository;
import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.service.house.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    HouseRepository houseRepository;

    @Override
    public List<House> searchHouseByAddress(String address) {
        return houseRepository.findByAddress(address);
    }
}
