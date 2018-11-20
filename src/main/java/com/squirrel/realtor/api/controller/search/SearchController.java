package com.squirrel.realtor.api.controller.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(value = "/api/search", produces = "application/json;charset=utf-8")
    public String searchHouseAndNearBy(@RequestParam(name = "address") String address) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<House> listHouse = searchService.searchHouseByAddress(address);
        return mapper.writeValueAsString(listHouse);
    }
}
