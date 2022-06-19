package com.selimsahin.survey.service;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.entity.Topic;
import com.selimsahin.survey.entity.UserResponses;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.repository.SurveyRepository;
import com.selimsahin.survey.repository.TopicRepository;
import com.selimsahin.survey.repository.UserResponsesRepository;
import com.selimsahin.survey.request.CreateTopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Topic saveTopic(CreateTopicRequest createTopicRequest) throws CloudException {
        Topic topic = new Topic();
        topic.setTitle(createTopicRequest.getTitle());
        return topicRepository.save(topic);
    }

    public void saveNPS(long id) {
        Topic topic = getTopicBySurveyId(id);
        topic = calculateNPS(topic);
        topicRepository.save(topic);
    }

    public Topic calculateNPS(Topic topic) {
        List<UserResponses> supporters = userResponsesRepository.findByScoreGreaterThan(8);
        List<UserResponses> perpetrator = userResponsesRepository.findByScoreLessThan(7);
        long respondentsCount = userResponsesRepository.count();

        double nps = ((double) supporters.size() - perpetrator.size()) / respondentsCount * 100d;

        topic.setNpsScore(nps);
        return topic;
    }

    public Topic getTopicBySurveyId(long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.orElseThrow().getTopic();
    }

}
