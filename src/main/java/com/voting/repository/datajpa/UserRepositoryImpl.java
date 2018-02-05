package com.voting.repository.datajpa;

import com.voting.model.User;
import com.voting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    CrudUserRepository crudUserRepository;

    @Override
    public User save(User user) {
        return crudUserRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudUserRepository.deleteById(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudUserRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll();
    }

    @Override
    public User getByEmail(String email){
        return crudUserRepository.findByEmail(email);
    }

}
