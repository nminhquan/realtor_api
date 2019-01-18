package com.squirrel.realtor.api.dao.house.mongo;

import com.squirrel.realtor.api.model.dto.House;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseMongoRepository extends MongoRepository<House, String> {
    List<House> findByAddressLike(String address);
    List<House> findByAddress(String address);
    List<House> findByLocationWithin(Circle c);
    List<House> findByLocationNear(Point p, Distance d);
//    List<House> findByAgentId(Long agentId);
}
