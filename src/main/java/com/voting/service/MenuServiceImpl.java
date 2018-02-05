package com.voting.service;

import com.voting.model.Menu;
import com.voting.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public boolean delete(int id) {
        return menuRepository.delete(id);
    }

    @Override
    public Menu get(int id) {
        return menuRepository.get(id);
    }

    @Override
    public Menu getByRestaurantId(int restaurant_id) {
        return menuRepository.findByRestaurant(restaurant_id);
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.getAll();
    }
}
