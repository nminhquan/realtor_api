package com.squirrel.realtor.api.service.search;

import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.model.dto.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {
    List<House> searchHouse(String text, int bedrooms, int bathrooms, double sqft, double price) ;
    List<House> searchNearByHouse(double lat, double lon, double dist);
}
