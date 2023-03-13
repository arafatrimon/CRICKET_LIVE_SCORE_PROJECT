package com.example.cricket_score.repository;

import com.example.cricket_score.model.MatchTeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchTeamDetailsRepository extends JpaRepository<MatchTeamDetails,Long> {
}
