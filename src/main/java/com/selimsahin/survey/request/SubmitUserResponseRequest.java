package com.selimsahin.survey.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitUserResponseRequest {
    @NotNull(message = "Survey Id is mandatory")
    private long surveyId;
    @NotBlank(message = "Answer is mandatory")
    private String answer;
    @Size(min = 1 , max = 10)
    private int score;
}
