package com.voting.repository;

import com.voting.model.Menu;

import java.util.List;

public interface MenuRepository {

    Menu save(Menu menu);

    boolean delete(int id);

    Menu get(int id);

    List<Menu> getAll();

    Menu findByRestaurant(int id);

}
