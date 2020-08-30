package com.gucarsoft.karisikkelimelerbe.controller;

import com.gucarsoft.karisikkelimelerbe.service.AnswerService;
import com.gucarsoft.karisikkelimelerbe.service.QuestionService;
import com.gucarsoft.karisikkelimelerbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    public AnswerService answerService;

    @Autowired
    public UserService userService;

    @Autowired
    public QuestionService questionService;


}
