package com.QuestionQuiz.QuestionQuiz.DaoPkg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuestionQuiz.QuestionQuiz.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
	

}
