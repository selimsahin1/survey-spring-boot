package com.selimsahin.survey.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSurveyRequest {
    private String question;
    private int score;
    private String feedback;
    private long topicId;
}
