package com.squirrel.realtor.api.unit;

import com.squirrel.realtor.api.dao.house.HouseDAO;
import com.squirrel.realtor.api.dao.house.mysql.HouseRepository;
import com.squirrel.realtor.api.model.dto.House;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBCTemplateTest {
    @Autowired
    HouseRepository houseRepository;

    @Autowired
    HouseDAO houseDAO;

    @Test
    public void repoTest() {
        Iterable<House> ret = houseRepository.findAll();
        System.out.println(ret);
    }

    @Test
    public void daoTest() {
        List<House> ls = houseDAO.searchNearByHouse("%Gibson%");
        System.out.println(ls);
        assert (ls.size() >= 0);
    }

}
