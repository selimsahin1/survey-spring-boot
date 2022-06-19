package com.selimsahin.survey.service;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.repository.TopicRepository;
import com.selimsahin.survey.request.CreateSurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SurveyService {
    @Autowired
    TopicRepository topicRepository;

    public Survey saveSurvey(CreateSurveyRequest createSurveyRequest) throws CloudException {
        Survey survey = new Survey();
        survey.setQuestion(createSurveyRequest.getQuestion());
        survey.setFeedback(createSurveyRequest.getFeedback());
        survey.setTopic(topicRepository.findById(createSurveyRequest.getTopicId()).orElseThrow());
        survey.setCreateTime(LocalDate.now());
        return survey;
    }
}
