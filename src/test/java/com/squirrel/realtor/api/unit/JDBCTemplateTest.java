package com.squirrel.realtor.api.unit;

import com.squirrel.realtor.api.dao.HouseRepository;
import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.service.search.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBCTemplateTest {
    @Autowired
    HouseRepository houseRepository;

    @Test
    public void repoTest() {
        Iterable<House> ret = houseRepository.findAll();
        System.out.println(ret);
    }

}
