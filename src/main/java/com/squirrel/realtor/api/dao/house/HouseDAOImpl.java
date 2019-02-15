package com.squirrel.realtor.api.dao.house;

import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.model.dto.RowMapper.HouseRowMapper;
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
    public List<House> searchNearByHouse(double lat, double lng, double distance) {
        // We can use either jdbctemplate or houseRepository
        List<House> list = jdbcTemplate.query(
                "select *, \n" +
                        "ST_Distance_Sphere(pos, ST_GeomFromText('POINT(" + lat + " " + lng + ")')) as distance\n" +
                        "from House\n" +
                        "having distance < ?"
                , new Object[] {distance}, new HouseRowMapper());
        return list;
    }
}
