package com.gucarsoft.karisikkelimelerbe.service;

import com.gucarsoft.karisikkelimelerbe.model.Answer;
import com.gucarsoft.karisikkelimelerbe.model.AnswerPojo;
import com.gucarsoft.karisikkelimelerbe.model.Question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional(readOnly=true)
public class AnswerService extends BaseService {
    public List<Answer> findAll() {
        return answerRepo.findAll();
    }

    public Answer findById(Long id) {
        return answerRepo.findById(id).orElse(null);
    }

    public Answer save(AnswerPojo answerPojo) {
//        answer.getQuestion().setId(questionRepo.findAllByWord((answer.getQuestion().getWord())).getId());
        Question question = questionRepo.findAllByWord(answerPojo.getQuestionWord());
        Answer answer=new Answer();
        answer.setWord(answerPojo.getWord());
        answer.setQuestionWord(question.getWord());
        answer.setDeleted(false);
        return answerRepo.save(answer);
    }

    public Answer update(Answer answer) {
        Answer existing = findById(answer.getId());
        if (answer.getWord() != null) {
            existing.setWord(answer.getWord());
        }
//        if (answer.getQuestion() != null) {
//            existing.setQuestion(answer.getQuestion());
//        }
        if (answer.getDeleted() != null) {
            existing.setDeleted(answer.getDeleted());
        }
        return answerRepo.save(existing);
    }

    public Answer delete(Long id) {
        Answer existing = findById(id);
        existing.setDeleted(true);
        return answerRepo.save(existing);
    }
}
