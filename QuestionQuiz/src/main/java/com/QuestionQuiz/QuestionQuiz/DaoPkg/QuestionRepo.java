package com.QuestionQuiz.QuestionQuiz.DaoPkg;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuestionQuiz.QuestionQuiz.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);
}
