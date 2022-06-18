package com.selimsahin.survey.repository;

import com.selimsahin.survey.entity.UserResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserResponsesRepository extends JpaRepository<UserResponses, Long> {
    List<UserResponses> findAllById(Long id);

    List<UserResponses> findByScoreGreaterThan(Long score);

    List<UserResponses> findByScoreLessThan(Long score);
}
