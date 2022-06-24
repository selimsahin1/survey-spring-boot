package com.selimsahin.survey.service;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.entity.UserResponses;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.repository.SurveyRepository;
import com.selimsahin.survey.repository.UserResponsesRepository;
import com.selimsahin.survey.request.CreateSurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    UserResponsesRepository userResponsesRepository;

    public Survey saveSurvey(CreateSurveyRequest createSurveyRequest) throws CloudException {
        Survey survey = new Survey();
        survey.setQuestion(createSurveyRequest.getQuestion());
        survey.setTopic(createSurveyRequest.getTopic());
        survey.setCreateTime(LocalDate.now());
        surveyRepository.save(survey);
        return survey;
    }

    public void saveNPS(long id) {
        Survey topic = surveyRepository.findById(id).orElse(new Survey());
        topic = calculateNPS(topic);
        surveyRepository.save(topic);
    }

    public Survey calculateNPS(Survey survey) {
        List<UserResponses> supporters = userResponsesRepository.findByScoreGreaterThan(8);
        List<UserResponses> perpetrator = userResponsesRepository.findByScoreLessThan(7);
        long respondentsCount = userResponsesRepository.count();

        double nps = ((double) supporters.size() - perpetrator.size()) / respondentsCount * 100d;

        survey.setNpsScore(nps);
        return survey;
    }
}
