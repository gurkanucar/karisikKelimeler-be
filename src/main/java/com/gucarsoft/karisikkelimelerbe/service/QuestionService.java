package com.gucarsoft.karisikkelimelerbe.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gucarsoft.karisikkelimelerbe.model.Answer;
import com.gucarsoft.karisikkelimelerbe.model.Question;
import com.gucarsoft.karisikkelimelerbe.model.QuestionPojo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Service
@Transactional(readOnly=true)
public class QuestionService extends BaseService {
    public List<Question> findAll() {
        List<Question> questionList = questionRepo.findAll();
        for (Question question:questionList
             ) {
         question.setAnswer(answerRepo.findAllByQuestionWordAndDeletedFalse(question.getWord()));
        }
        return questionList;
    }

    public List<QuestionPojo> findAllPublic() {
        List<Question> questionList = questionRepo.findAll();
        List<QuestionPojo> questionPojoList = new ArrayList<>();

        for (Question question:questionList
        ) {
            List<String> answerObjectList = new ArrayList<>();
            Collection<Answer> collection = answerRepo.findAllByQuestionWordAndDeletedFalse(question.getWord());
            for (Answer answer:collection
            ) {
                answerObjectList.add(answer.getWord());
            }
            QuestionPojo questionPojo=new QuestionPojo();
            questionPojo.setQuestionName(question.getWord());
            questionPojo.setAnswerList(answerObjectList);
            questionPojoList.add(questionPojo);
        }
        return questionPojoList;
    }

    public Question findById(Long id) {

        return questionRepo.findById(id).orElse(null);
    }

    public Question save(Question question) {
        question.setLength(question.getWord().toString().length());
        return questionRepo.save(question);
    }

    public Question update(Question question) {
        Question existing = findById(question.getId());
        if (question.getWord() != null) {
            existing.setWord(question.getWord());
        }
        if (question.getLength() != null) {
            existing.setLength(question.getLength());
        }
        if (question.getDeleted() != null) {
            existing.setDeleted(question.getDeleted());
        }
        return questionRepo.save(existing);
    }

    public Question delete(Long id) {
        Question existing = findById(id);
        existing.setDeleted(true);
        return questionRepo.save(existing);
    }
}
