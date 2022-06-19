package com.selimsahin.survey.service;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.entity.Topic;
import com.selimsahin.survey.repository.SurveyRepository;
import com.selimsahin.survey.repository.TopicRepository;
import com.selimsahin.survey.repository.UserResponsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    SurveyService surveyService;
    @Autowired
    UserResponsesRepository userResponsesRepository;
    @Autowired
    TopicRepository topicRepository;

    public void saveNPS(long id) {
        Topic topic = getTopicBySurveyId(id);
        topic = calculateNPS(topic);
        topicRepository.save(topic);
    }

    public Topic calculateNPS(Topic topic) {
        long supporterCount = userResponsesRepository.findByScoreGreaterThan(8L).size();
        long perpetratorCount = userResponsesRepository.findByScoreLessThan(7L).size();
        long respondentsCount = userResponsesRepository.count();

        double nps = ((double) supporterCount - perpetratorCount) / respondentsCount * 100d;

        topic.setNpsScore(nps);
        return topic;
    }

    public Topic getTopicBySurveyId(long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.orElseThrow().getTopic();
    }

}
