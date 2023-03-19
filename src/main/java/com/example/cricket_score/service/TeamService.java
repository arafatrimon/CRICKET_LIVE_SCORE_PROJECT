package com.example.cricket_score.service;

import com.example.cricket_score.model.Team;
import com.example.cricket_score.repository.MatchTeamDetailsRepository;
import com.example.cricket_score.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonSerializable;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MatchTeamDetailsRepository matchTeamDetailsRepository;

    public void save(Team team) {
        teamRepository.save(team);
    }

    public void updateValue(Team team) throws NoSuchFieldException {
        List<?> matchTeam = matchTeamDetailsRepository.getValue(team.getMatchId());

        for (int counter = 0; counter < matchTeam.size(); counter++) {
            System.out.println(matchTeam.get(counter));

            Object obj1 = matchTeam.get(counter);
            
        }

//        for (Object obj : matchTeam) {
//            obj.getClass().getDeclaredField("0");
//            System.out.println(obj);
//
//            if (obj.equals(team.getId())) {
//                 int val = teamRepository.updateValue(team.getRole(), team.getInnings(), team.getId());
////                team.setRole("bowl");
////                int val2 = teamRepository.updateValue(team.getRole(), team.getInnings(), team.getId());
//            }else if (obj.equals(1)){
//                team.setRole("bowl");
//                int val2 = teamRepository.updateValue(team.getRole(), team.getInnings(), 1);
//            }
//
//        }


//        if (team.getId() != null) {
//            int val = teamRepository.updateValue(team.getRole(), team.getInnings(), team.getId());
//
//        } else {
//            System.out.println("Need team id");
//        }

    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
