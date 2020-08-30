package com.gucarsoft.karisikkelimelerbe.repository;

import com.gucarsoft.karisikkelimelerbe.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestionWordAndDeletedFalse(String word);
}
