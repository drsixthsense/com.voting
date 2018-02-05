package com.voting.service;

import com.voting.model.Menu;

import java.util.List;

public interface MenuService {

    Menu save(Menu menu);

    boolean delete(int id);

    Menu get(int id);

    Menu getByRestaurantId(int restaurant_id);

    List<Menu> getAll();

}
