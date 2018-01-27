package com.voting.repository.datajpa;

import com.voting.model.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudRestorantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    int deleteById(int id);

    @Override
    Optional<Restaurant> save(Restaurant restaurant);

    @Override
    List<Restaurant> findAll(Sort sort);


}
