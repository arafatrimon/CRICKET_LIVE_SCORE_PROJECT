package com.example.cricket_score.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bowler")
public class Bowler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "integer default 0")
    private Integer bowl;
    @Column(columnDefinition = "integer default 0")
    private Integer run;
    @Column(columnDefinition = "integer default 0")
    private Integer maidenOver;
    @Column(columnDefinition = "integer default 0")
    private Integer wicket;


    @Transient
    private Double over;

    @Transient
    public Double getOver() {
        double over = bowl / 6;
        return over;
    }
}
