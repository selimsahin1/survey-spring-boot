package com.selimsahin.survey.entity;

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
    @Column(name = "createTime")
    private LocalDate createTime;
    @Column(name = "question")
    private String question;
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
    @OneToMany(mappedBy = "survey")
    private Set<UserResponses> userResponses;
}
