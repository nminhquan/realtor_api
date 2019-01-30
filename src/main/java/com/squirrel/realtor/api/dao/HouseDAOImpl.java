package com.squirrel.realtor.api.dao;

import com.squirrel.realtor.api.dao.mysql.HouseRepository;
import com.squirrel.realtor.api.dto.mysql.House;
import com.squirrel.realtor.api.dto.RowMapper.HouseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseDAOImpl implements HouseDAO {
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

    @Override
    public House addNewHouse(House house) {
        return houseRepository.save(house);
    }
}
