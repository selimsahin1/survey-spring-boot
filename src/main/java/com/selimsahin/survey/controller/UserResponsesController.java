package com.selimsahin.survey.controller;

import com.selimsahin.survey.entity.UserResponses;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.exception.HttpExceptionEnum;
import com.selimsahin.survey.repository.SurveyRepository;
import com.selimsahin.survey.repository.UserResponsesRepository;
import com.selimsahin.survey.request.SubmitUserResponseRequest;
import com.selimsahin.survey.service.SurveyService;
import com.selimsahin.survey.service.UserResponsesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import response.BaseResponse;

import java.util.List;

@RestController
@RequestMapping
public class UserResponsesController {
    @Autowired
    UserResponsesRepository userResponsesRepository;
    @Autowired
    UserResponsesService saveUserResponseService;
    @Autowired
    SurveyService surveyService;
    @Autowired
    SurveyRepository surveyRepository;

    @PostMapping(value = "/submit-survey")
    public BaseResponse submitSurvey(@RequestBody SubmitUserResponseRequest submitUserResponseRequest)
            throws CloudException {
        saveUserResponseService.saveUserResponse(submitUserResponseRequest);
        surveyService.saveNPS(submitUserResponseRequest.getSurveyId());
        return new BaseResponse<>();
    }

    @GetMapping(value = "/list-survey-answers")
    public List<UserResponses> listSurveyTopics(@RequestParam Long id) throws CloudException {
        try {
            return userResponsesRepository.findAllBySurvey(surveyRepository.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CloudException(HttpExceptionEnum.HTTP_INVALID_PARAMETER);
        }
    }
}
