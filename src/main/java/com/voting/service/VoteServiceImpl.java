package com.voting.service;

import com.voting.model.Vote;
import com.voting.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{

    @Autowired
    private VotesRepository votesRepository;

    @Override
    public Vote save(Vote vote) {
        return votesRepository.save(vote);
    }

    @Override
    public boolean delete(int id) {
        return votesRepository.delete(id);
    }

    @Override
    public Vote get(int id) {
        return votesRepository.get(id);
    }

    @Override
    public List<Vote> getAll() {
        return votesRepository.getAll();
    }
}
