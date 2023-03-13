package com.example.cricket_score.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String  name;
    private String owner;

    @Column(columnDefinition = "varchar(255) default 'default'")
    private String toss;
}
