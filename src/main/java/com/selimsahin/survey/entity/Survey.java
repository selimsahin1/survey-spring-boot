package com.selimsahin.survey.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "createTime")
    private LocalDate createTime;
    @Column(name = "question")
    private String question;
    @Column(name = "feedback")
    private String feedback;
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
}
