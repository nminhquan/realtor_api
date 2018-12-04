package com.squirrel.realtor.api.controller.search;

import com.squirrel.realtor.api.model.dto.House;
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
    public List<House> searchHouseAndNearBy(@RequestParam(name = "address", required = false) String address) {
        List<House> listHouse = searchService.searchHouseByAddress(address);
        return listHouse;
    }
}
