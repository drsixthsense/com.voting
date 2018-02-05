package com.voting.repository.datajpa;

import com.voting.model.Menu;
import com.voting.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository{
    private static final Sort SORT_RESTAURANT = new Sort(Sort.Direction.ASC, "restaurant");

    @Autowired
    CrudMenuRepository crudMenuRepository;

    @Override
    public Menu save(Menu menu) {
        return crudMenuRepository.save(menu);
    }

    @Override
    public boolean delete(int id) {
        return crudMenuRepository.deleteById(id) != 0;
    }

    @Override
    public Menu get(int id) {
        return crudMenuRepository.findById(id).get();
    }

    @Override
    public List<Menu> getAll() {
        return crudMenuRepository.findAll(SORT_RESTAURANT);
    }

    @Override
    public Menu findByRestaurant(int id) {
        return crudMenuRepository.findByRestaurantId(id);
    }
}
