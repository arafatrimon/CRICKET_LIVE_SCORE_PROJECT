package com.example.cricket_score.repository;

import com.example.cricket_score.model.MatchTeamDetails;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchTeamDetailsRepository extends JpaRepository<MatchTeamDetails, Long> {
    @Query(value = "select t.id, t.name, m.match_team_details_id from team t, match_team_details_teams m where t.id = m.teams_id and m.match_team_details_id = :id", nativeQuery = true)
    Object [][] getValue(@Param("id") Long id);
}
