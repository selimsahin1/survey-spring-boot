package com.selimsahin.survey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonIgnore
    @Column(name = "createTime")
    private LocalDate createTime;
    @Column(name = "topic", unique = true)
    private String topic;
    @Column(name = "question")
    private String question;
    @Column(name = "npmScore")
    private double npsScore;
    @JsonIgnore
    @OneToMany(mappedBy = "survey")
    private Set<UserResponses> userResponses;
}
