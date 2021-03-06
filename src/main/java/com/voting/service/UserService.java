package com.voting.service;

import com.voting.model.User;

import java.util.List;

public interface UserService {


    User save(User user);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();

    User getByEmail(String email);

}
