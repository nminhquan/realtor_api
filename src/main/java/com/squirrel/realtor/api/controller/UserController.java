package com.squirrel.realtor.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.realtor.api.model.UserDTO;
import com.squirrel.realtor.api.model.UserRequest;
import com.squirrel.realtor.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserService service;

    @RequestMapping(value = "api/user", method = RequestMethod.POST)
    public String createUser(@RequestBody UserRequest samplRequest) throws JsonProcessingException {
        logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(samplRequest));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(samplRequest, userDTO);
        logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDTO));
        return service.createUser(userDTO);

    }
}
