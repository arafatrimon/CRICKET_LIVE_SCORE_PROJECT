package com.example.cricket_score.model;

import jakarta.persistence.Column;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class BowlerModel {
    private long id;

    private String name;

    private Integer bowl;

    private Integer run;

    private Integer maidenOver;

    private Integer wicket;

}
