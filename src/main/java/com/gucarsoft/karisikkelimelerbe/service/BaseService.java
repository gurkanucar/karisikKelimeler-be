package com.gucarsoft.karisikkelimelerbe.service;

import com.gucarsoft.karisikkelimelerbe.repository.AnswerRepository;
import com.gucarsoft.karisikkelimelerbe.repository.QuestionRepository;
import com.gucarsoft.karisikkelimelerbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    AnswerRepository answerRepo;

    @Autowired
    QuestionRepository questionRepo;

    @Autowired
    UserRepository userRepo;
}
