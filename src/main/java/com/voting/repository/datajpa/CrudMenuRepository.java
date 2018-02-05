package com.voting.repository.datajpa;

import com.voting.model.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CrudMenuRepository extends JpaRepository<Menu, Integer> {

    @Transactional
    @Modifying
    int deleteById(int id);

    @Override
    Menu save(Menu menu);

    @Override
    List<Menu> findAll(Sort sort);

    Menu findByRestaurantId(int id);

}
