package com.selimsahin.survey.service;

import com.selimsahin.survey.entity.UserResponses;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.repository.UserResponsesRepository;
import com.selimsahin.survey.request.SubmitUserResponseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserResponsesService {
    @Autowired
    TopicService topicService;
    @Autowired
    UserResponsesRepository userResponsesRepository;

    public UserResponses saveUserResponse(SubmitUserResponseRequest submitSurveyRequest) throws CloudException {
        UserResponses userResponses = new UserResponses();
        userResponses.setAnswer(submitSurveyRequest.getAnswer());
        userResponses.setCreateTime(LocalDate.now());
        userResponses.setScore(submitSurveyRequest.getScore());
        return userResponses;
    }
}
