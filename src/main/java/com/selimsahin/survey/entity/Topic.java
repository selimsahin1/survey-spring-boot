package com.selimsahin.survey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "npmScore")
    private double npsScore;
    @JsonIgnore
    @OneToMany(mappedBy = "topic")
    private Set<Survey> surveys;
}
