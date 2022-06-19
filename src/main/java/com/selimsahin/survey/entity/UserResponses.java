package com.selimsahin.survey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_responses")
public class UserResponses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @Column(name = "answer")
    private String answer;
    @Column(name = "score")
    private int score;
    @Column(name = "createTime")
    private LocalDate createTime;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
}
