package com.squirrel.realtor.api.service.user;

import com.squirrel.realtor.api.model.dto.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User createUser(User user) {
        return new User("p", ";", 1);
    }
}
