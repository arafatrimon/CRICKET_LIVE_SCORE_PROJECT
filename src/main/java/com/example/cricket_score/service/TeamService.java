package com.example.cricket_score.service;

import com.example.cricket_score.model.Team;
import com.example.cricket_score.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void save(Team team) {
        teamRepository.save(team);
    }
    public List<Team> getAllTeams(){
        return  teamRepository.findAll();
    }
}
