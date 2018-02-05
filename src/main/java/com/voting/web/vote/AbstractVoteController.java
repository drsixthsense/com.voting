package com.voting.web.vote;

import com.voting.model.Vote;
import com.voting.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractVoteController {

    @Autowired
    protected VoteService voteService;

    public List<Vote> getAll(){
        return voteService.getAll();
    }

    public Vote get(int id){
        return voteService.get(id);
    }

    public void delete(int id){
        voteService.delete(id);
    }

}
