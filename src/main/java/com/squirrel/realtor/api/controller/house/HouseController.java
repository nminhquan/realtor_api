package com.squirrel.realtor.api.controller.house;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.realtor.api.dao.HouseRepository;
import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.service.house.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseController {
    @Autowired
    HouseService houseService;

    @Autowired
    HouseRepository houseRepository;

    @RequestMapping(value = "/api/house", method = RequestMethod.POST)
    @ResponseBody
    public House addHouse(@RequestParam("address") String address) {
        return houseService.addAHouse(new House(address));
    }

    @GetMapping(value = "/api/house")
    public @ResponseBody Iterable<House> listHouse() {
        return houseRepository.findAll();
    }

    @GetMapping(value = "/api/house/{id}", produces = "application/json;charset=utf-8")
    public String getHouseById(@PathVariable(name = "id") long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(houseRepository.findById(id).get());
    }

}
