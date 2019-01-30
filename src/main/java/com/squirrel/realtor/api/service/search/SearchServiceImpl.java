package com.squirrel.realtor.api.service.search;

import com.squirrel.realtor.api.dao.mongo.HouseMongoRepository;
import com.squirrel.realtor.api.dto.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    HouseMongoRepository houseMongoRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<House> searchHouse(String text,
                                   int bedrooms,
                                   int bathrooms,
                                   double sqft,
                                   double price) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage()
                .matchingAny(text);
        Query query = new Query();
        query.addCriteria(
                new Criteria().orOperator(
                        Criteria.where("bedrooms").is(bedrooms),
                        Criteria.where("bathrooms").is(bathrooms),
                        Criteria.where("sqft").is(sqft),
                        Criteria.where("price").is(price)
                )
        ).addCriteria(textCriteria)
                .with(new PageRequest(0, 5));
        return mongoTemplate.find(query, House.class);
    }

    @Override
    public List<House> searchNearByHouse(double lat, double lon, double distance) {
        return houseMongoRepository.findByLocationNear(new Point(lat, lon), new Distance(distance, Metrics.MILES));
    }


}
