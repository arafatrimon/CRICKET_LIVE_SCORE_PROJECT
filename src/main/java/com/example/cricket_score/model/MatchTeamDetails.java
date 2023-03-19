package com.example.cricket_score.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MatchTeamDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int matchNo;
    @ManyToMany
    private List<Team> teams;
    @ManyToMany
    private List<Player> players;

}
