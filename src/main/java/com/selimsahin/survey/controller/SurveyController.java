package com.selimsahin.survey.controller;

import com.selimsahin.survey.entity.Survey;
import com.selimsahin.survey.exception.CloudException;
import com.selimsahin.survey.exception.HttpExceptionEnum;
import com.selimsahin.survey.repository.SurveyRepository;
import com.selimsahin.survey.request.CreateSurveyRequest;
import com.selimsahin.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import response.BaseResponse;

import java.util.List;

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

    @GetMapping(value = "/get-survey")
    public List<Survey> getSurvey(@RequestParam(required = false) Long id) throws CloudException {
        try {
            if (id == null)
                return surveyRepository.findAll();
            else
                return surveyRepository.findAllById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CloudException(HttpExceptionEnum.HTTP_INVALID_PARAMETER);
        }
    }
}
