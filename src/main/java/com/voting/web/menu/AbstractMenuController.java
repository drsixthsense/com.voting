package com.voting.web.menu;

import com.voting.model.Menu;
import com.voting.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractMenuController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    public List<Menu> getAll(){
        return menuService.getAll();
    }

    public Menu get(int id){
        return menuService.get(id);
    }

    public void delete(int id){
        menuService.delete(id);
    }

    public Menu getByRestaurant(int restaurant_id){
        return menuService.getByRestaurantId(restaurant_id);
    }

}
