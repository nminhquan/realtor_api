package com.squirrel.realtor.api.controller;

import com.squirrel.realtor.api.dto.House;
import com.squirrel.realtor.api.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(value = "/api/search", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<House> searchHouseByAnyText(@RequestParam(name = "text") String text,
                                            @RequestParam(name = "bedrooms", required = false, defaultValue = "0.0") int bedrooms,
                                            @RequestParam(name = "bathrooms", required = false, defaultValue = "0.0") int bathrooms,
                                            @RequestParam(name = "sqft", required = false, defaultValue = "0.0") double sqft,
                                            @RequestParam(name = "price", required = false, defaultValue = "0.0") double price) {
        List<House> listHouse = searchService.searchHouse(text, bedrooms, bathrooms, sqft, price);
        return listHouse;
    }

    @GetMapping(value = "/api/search_near", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<House> searchNearByHouses(@RequestParam(name = "lat") Double lat,
                                            @RequestParam(name = "lon") Double lon,
                                          @RequestParam(name = "distance") Double distance) {
        List<House> listHouse = searchService.searchNearByHouse(lat, lon, distance);
        return listHouse;
    }
}
