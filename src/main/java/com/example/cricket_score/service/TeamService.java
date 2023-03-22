package com.example.cricket_score.service;

import com.example.cricket_score.model.Team;
import com.example.cricket_score.repository.MatchTeamDetailsRepository;
import com.example.cricket_score.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void updateValue(Team team) {
        Object[][] matchTeam = matchTeamDetailsRepository.getValue(team.getMatchId());
        if (matchTeam[0][0] == team.getId()) {
            teamRepository.updateValue(team.getRole(), team.getInnings(), team.getId());

            if (team.getRole() == "Bat") {
                team.setRole("Ball");
            }else {
                team.setRole("Bat");
            }

            teamRepository.updateValue(team.getRole(), team.getInnings(), (Long) matchTeam[1][0]);
        }
        if (matchTeam[1][0] == team.getId()) {
            teamRepository.updateValue(team.getRole(), team.getInnings(), team.getId());
            if (team.getRole() == "Bat") {
                team.setRole("Ball");
            }else {
                team.setRole("Bat");
            }

            teamRepository.updateValue(team.getRole(), team.getInnings(), (Long) matchTeam[0][0]);
        }
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
