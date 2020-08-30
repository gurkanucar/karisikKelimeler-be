package com.gucarsoft.karisikkelimelerbe.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="word", unique = true)
    private String word;
    private Integer length;
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Answer> answer;
    private Boolean deleted;

}
