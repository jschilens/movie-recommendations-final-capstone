package com.techelevator.controller;


import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/users/current", method = RequestMethod.GET)
    public User getCurrentUser(Principal principal) {
        return userDao.findByUsername(principal.getName());
    }


}
