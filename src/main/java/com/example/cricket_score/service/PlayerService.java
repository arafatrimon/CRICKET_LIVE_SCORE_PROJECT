package com.example.cricket_score.service;

import com.example.cricket_score.model.Player;
import com.example.cricket_score.model.Team;
import com.example.cricket_score.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService  {
    @Autowired
    private PlayerRepository playerRepository;

    public Player save(Player player){
        return playerRepository.save(player);
    }

    public List<Player> findPlayerByTeam(Long id){
        Team team=new Team();
        team.setId(id);
        return  playerRepository.findPlayerByTeam(team);
    }
}
