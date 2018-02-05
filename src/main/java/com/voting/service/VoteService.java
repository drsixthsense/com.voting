package com.voting.service;

import com.voting.model.Vote;

import java.util.List;

public interface VoteService {
    Vote save(Vote vote);

    boolean delete(int id);

    Vote get(int id);

    List<Vote> getAll();
}
