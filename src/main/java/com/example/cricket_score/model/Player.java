package com.example.cricket_score.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String age;
    private String mobileNo;
    private String address;

    @ManyToOne
    private Team team;
}
