package com.selimsahin.survey.controller;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.entity.Topic;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.exception.HttpExceptionEnum;
import com.selimsahin.survey.repository.TopicRepository;
import com.selimsahin.survey.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TopicController {
    @Autowired
    TopicService topicService;
    @Autowired
    TopicRepository topicRepository;

    @GetMapping(value = "/list-survey-topics")
    public List<Topic> listSurveyTopics(@RequestParam Long id) throws CloudException {
        try {
            return topicRepository.findAllById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CloudException(HttpExceptionEnum.HTTP_INVALID_PARAMETER);
        }
    }
}
