package com.voting.repository.datajpa;

import com.voting.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    int deleteById(int id);

    @Transactional
    @Override
    User save(User user);

    @Override
    List<User> findAll(Sort sort);

    User findByEmail(String email);

}
