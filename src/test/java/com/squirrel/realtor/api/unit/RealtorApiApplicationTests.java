package com.squirrel.realtor.api.unit;

import com.squirrel.realtor.api.dao.house.mongo.HouseMongoRepository;
import com.squirrel.realtor.api.model.dto.House;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealtorApiApplicationTests {
	@Autowired
	HouseMongoRepository repo;

	@Test
	public void testApplication() {
		System.out.println("This is Test");
	}

	@Test public void shouldFindAroundOrigin() {
		// when
		List<House> locations = repo.findByLocationNear( new Point(-73.961704, 40.662943), new Distance(10, Metrics.KILOMETERS));

		System.out.println(locations);
	}
}
