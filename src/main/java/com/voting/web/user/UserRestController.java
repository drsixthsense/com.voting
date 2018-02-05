package com.voting.web.user;

import com.voting.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = UserRestController.REST_URL)
public class UserRestController extends AbstractUserController{
    static final String REST_URL = "/rest/users";

    @Override
    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll(){
        return super.getAll();
    }
}
