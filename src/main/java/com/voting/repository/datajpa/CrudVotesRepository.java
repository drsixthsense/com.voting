package com.voting.repository.datajpa;

import com.voting.model.Vote;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CrudVotesRepository extends JpaRepository<Vote, Integer> {

    @Transactional
    @Modifying
    int deleteById(int id);

    @Override
    @Transactional
    Vote save(Vote vote);

    @Override
    List<Vote> findAll(Sort sort);

}
