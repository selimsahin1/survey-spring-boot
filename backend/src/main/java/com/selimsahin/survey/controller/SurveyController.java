package com.selimsahin.survey.controller;

import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.repository.SurveyRepository;
import com.selimsahin.survey.request.CreateSurveyRequest;
import com.selimsahin.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.BaseResponse;

@RestController
@RequestMapping
public class SurveyController {
    @Autowired
    SurveyService surveyService;
    @Autowired
    SurveyRepository surveyRepository;

    @PostMapping(value = "/create-survey")
    public BaseResponse createSurvey(@RequestBody CreateSurveyRequest createSurveyRequest) throws CloudException {
        surveyService.saveSurvey(createSurveyRequest);
        return new BaseResponse<>();
    }
}
