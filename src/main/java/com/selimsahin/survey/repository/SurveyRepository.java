package com.selimsahin.survey.repository;

import com.selimsahin.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findAllById(Long id);

    Optional<Survey> findById(Long id);
}
