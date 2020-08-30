package com.gucarsoft.karisikkelimelerbe.model;

import lombok.Data;

import java.util.Collection;

@Data
public class QuestionPojo {
    private String questionName;
    private Collection<String> answerList;
}
