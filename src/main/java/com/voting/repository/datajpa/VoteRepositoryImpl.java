package com.voting.repository.datajpa;

import com.voting.model.Vote;
import com.voting.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoteRepositoryImpl implements VotesRepository {

    @Autowired
    private CrudVotesRepository crudVotesRepository;

    @Override
    public Vote save(Vote vote) {
        return crudVotesRepository.save(vote);
    }

    @Override
    public boolean delete(int id) {
        return crudVotesRepository.deleteById(id) !=0;
    }

    @Override
    public Vote get(int id) {
        return crudVotesRepository.findById(id).get();
    }

    @Override
    public List<Vote> getAll() {
        return crudVotesRepository.findAll();
    }
}
