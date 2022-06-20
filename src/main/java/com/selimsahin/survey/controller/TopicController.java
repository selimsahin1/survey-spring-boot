package com.selimsahin.survey.controller;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.entity.Topic;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.exception.HttpExceptionEnum;
import com.selimsahin.survey.repository.TopicRepository;
import com.selimsahin.survey.request.CreateSurveyRequest;
import com.selimsahin.survey.request.CreateTopicRequest;
import com.selimsahin.survey.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import response.BaseResponse;

import java.util.List;

@RestController
@RequestMapping
public class TopicController {
    @Autowired
    TopicService topicService;
    @Autowired
    TopicRepository topicRepository;

    @GetMapping(value = "/list-survey-topics")
    public List<Topic> listSurveyTopics(@RequestParam(required = false) Long id) throws CloudException {
        try {
            if (id == null)
                return topicRepository.findAll();
            else
                return topicRepository.findAllById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CloudException(HttpExceptionEnum.HTTP_INVALID_PARAMETER);
        }
    }

    @PostMapping(value = "create-topic")
    public BaseResponse createTopic(@RequestBody CreateTopicRequest createTopicRequest) throws CloudException {
        topicService.saveTopic(createTopicRequest);
        return new BaseResponse<>();
    }
}
