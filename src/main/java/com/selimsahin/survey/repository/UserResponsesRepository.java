package com.selimsahin.survey.repository;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.entity.UserResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserResponsesRepository extends JpaRepository<UserResponses, Long> {
    List<UserResponses> findAllBySurvey(Optional<Survey> survey);

    List<UserResponses> findByScoreGreaterThan(int score);

    List<UserResponses> findByScoreLessThan(int score);
}
