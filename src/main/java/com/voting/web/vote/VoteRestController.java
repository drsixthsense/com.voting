package com.voting.web.vote;

import com.voting.model.Vote;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL)
public class VoteRestController extends AbstractVoteController {
    static final String REST_URL = "/rest/votes";

    @Override
    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> getAll(){
        return super.getAll();
    }

}
