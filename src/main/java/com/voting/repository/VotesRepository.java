package com.voting.repository;

import com.voting.model.Vote;

import java.util.List;

public interface VotesRepository {


    Vote save(Vote vote);

    boolean delete(int id);

    Vote get(int id);

    List<Vote> getAll();
}
