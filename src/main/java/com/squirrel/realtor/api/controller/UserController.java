package com.squirrel.realtor.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.realtor.api.model.dto.User;
import com.squirrel.realtor.api.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserService service;

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public @ResponseBody String createUser(@RequestParam(name = "name") String name) throws JsonProcessingException {
        User user = new User();
        return mapper.writeValueAsString(service.createUser(user));

    }
}
