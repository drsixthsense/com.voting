package com.voting.repository;

import com.voting.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {


    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();
}
