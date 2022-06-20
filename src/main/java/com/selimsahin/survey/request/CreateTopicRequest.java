package com.selimsahin.survey.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTopicRequest {
    @NotBlank(message = "Title is mandatory")
    private String title;
}
