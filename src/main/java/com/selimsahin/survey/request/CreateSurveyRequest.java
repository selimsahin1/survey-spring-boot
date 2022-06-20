package com.selimsahin.survey.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSurveyRequest {
    @NotBlank(message = "Question is mandatory")
    private String question;
    @NotNull(message = "Topic Id is mandatory")
    private long topicId;
}
