package com.voting.web.menu;

import com.voting.model.Menu;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(MenuRestController.REST_URL)
public class MenuRestController extends AbstractMenuController{
    static final String REST_URL = "/rest/menu";

    @Override
    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getAll(){
        return super.getAll();
    }
}
