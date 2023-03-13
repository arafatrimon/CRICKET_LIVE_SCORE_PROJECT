package com.example.cricket_score.service;

import com.example.cricket_score.model.MatchTeamDetails;
import com.example.cricket_score.repository.MatchTeamDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchTeamDetailsService {

    @Autowired
    private MatchTeamDetailsRepository matchTeamDetailsRepository;

    public MatchTeamDetails save(MatchTeamDetails matchTeamDetails){
        return matchTeamDetailsRepository.save(matchTeamDetails);
    }

}
