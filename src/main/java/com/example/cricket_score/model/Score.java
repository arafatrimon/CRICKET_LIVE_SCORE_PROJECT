package com.example.cricket_score.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "integer default 0")
    private Integer totalRuns;
    @Transient
    private Integer runs;
    @Column(columnDefinition = "integer default 0")
    private Integer bowl;
    private String runType;
    private String runExtra;
    private String batsmanOutType;
    @Transient
    private String bowler;
}
