package com.gucarsoft.karisikkelimelerbe.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "word", unique = true)
    private String word;
    private Boolean deleted;
    private String questionWord;
}
