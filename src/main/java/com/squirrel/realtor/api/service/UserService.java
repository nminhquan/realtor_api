package com.squirrel.realtor.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squirrel.realtor.api.controller.UserController;
import com.squirrel.realtor.api.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    ObjectMapper mapper = new ObjectMapper();

    public String createUser(UserDTO user) throws JsonProcessingException {
        return mapper.writeValueAsString(user);
    }
}
