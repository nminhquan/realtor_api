package com.squirrel.realtor.api.controller.house;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.realtor.api.controller.user.UserController;
import com.squirrel.realtor.api.dao.house.HouseRepository;
import com.squirrel.realtor.api.model.dto.House;
import com.squirrel.realtor.api.service.house.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HouseController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

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
    @ResponseBody
    public Iterable<House> listHouse() {
        return houseRepository.findAll();
    }

    @GetMapping(value = "/api/house/{id}", produces = "application/json;charset=utf-8")
    public String getHouseById(@PathVariable(name = "id") long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(houseRepository.findById(id).get());
    }

    @DeleteMapping(value = "/api/house/{id}", produces = "application/json;charset=utf-8")
    public void deleteHouseById(@PathVariable(name = "id") long id) {
        houseRepository.deleteById(id);
    }

    @PutMapping(value = "/api/house/{id}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public House updateHouse(@PathVariable("id") long id, @RequestParam("address") String address) {
        House updatedHouse = null;
        try {
            updatedHouse = houseRepository.findById(id)
                    .map(house -> new House(address))
                    .orElseThrow(() -> new Exception());
        } catch (Exception e) {
            logger.error("Could not update House id = " + id, e);
        }

        return updatedHouse;
    }

}
