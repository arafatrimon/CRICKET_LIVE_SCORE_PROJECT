package com.example.cricket_score.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer totalRuns;
    @Transient
    private Integer runs;
    private Integer bowl;

    private String runType;
    private String runExtra;
    private String batsmanOutType;
}
