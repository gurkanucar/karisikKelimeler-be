package com.gucarsoft.karisikkelimelerbe.repository;

import com.gucarsoft.karisikkelimelerbe.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findAllByWord(String word);
}
