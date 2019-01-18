package com.squirrel.realtor.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.model.dto.Location;
import com.squirrel.realtor.api.service.house.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HouseController {
    Logger logger = LoggerFactory.getLogger(HouseController.class);

    @Autowired
    HouseService houseService;

    @RequestMapping(value = "/api/house", method = RequestMethod.POST)
    @ResponseBody
    public House addHouse(@RequestParam("address") String address,
                          @RequestParam("ownerName") String ownerName,
                          @RequestParam("builderName") String builderName,
                          @RequestParam("bedrooms") int bedrooms,
                          @RequestParam("bathrooms") int bathrooms,
                          @RequestParam("sqft") float sqft,
                          @RequestParam("agentId") String agentId,
                          @RequestParam("coordinates") Double[] coordinates) {
        return houseService.addAHouse(
                House.builder()
                        .address(address)
                        .ownerName(ownerName)
                        .builderName(builderName)
                        .bedrooms(bedrooms)
                        .bathrooms(bathrooms)
                        .sqft(sqft)
                        .agentId(agentId)
                        .location(new Location(coordinates, "Point"))
                        .build()
        );
    }

    @GetMapping(value = "/api/house")
    @ResponseBody
    public Iterable<House> listHouse() {
        return houseService.getAllHouses();
    }

    @GetMapping(value = "/api/house/{id}", produces = "application/json;charset=utf-8")
    public String getHouseById(@PathVariable(name = "id") String id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(houseService.getHouseById(id).get());
    }

    @DeleteMapping(value = "/api/house/{id}", produces = "application/json;charset=utf-8")
    public void deleteHouseById(@PathVariable(name = "id") String id) {
        houseService.removeHouse(id);
    }

    @PutMapping(value = "/api/house/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public House updateHouse(@PathVariable("id") String id, @RequestParam("address") String address) {
        House updatedHouse = null;
        try {
            updatedHouse = houseService.updateHouseAddress(id, address);
        } catch (Exception e) {
            logger.error("Could not update House id = " + id, e);
        }

        return updatedHouse;
    }

}
