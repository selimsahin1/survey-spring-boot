package com.selimsahin.survey.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "npmScore")
    private double npsScore;
    @OneToMany(mappedBy = "topic")
    private Set<Survey> surveys;
}
