package com.squirrel.realtor.api.dao.house;

import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.model.dto.RowMapper.HouseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseJdbcDAO implements HouseDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HouseRepository houseRepository;

    @Override
    public List<House> searchNearByHouse(String address) {
        // We can use either jdbctemplate or houseRepository
        List<House> list = jdbcTemplate.query("select * from house where address like ?", new Object[] {address}, new HouseRowMapper());
        return list;
    }
}
