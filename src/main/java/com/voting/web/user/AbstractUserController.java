package com.voting.web.user;

import com.voting.model.User;
import com.voting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbstractUserController {

    @Autowired
    UserService userService;

    public List<User> getAll(){
        return userService.getAll();
    }

    public User get(int id){
        return userService.get(id);
    }

    public void delete(int id){
        userService.delete(id);
    }

}
