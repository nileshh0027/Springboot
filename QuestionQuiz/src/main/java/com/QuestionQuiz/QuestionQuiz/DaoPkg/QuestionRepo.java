package com.QuestionQuiz.QuestionQuiz.DaoPkg;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QuestionQuiz.QuestionQuiz.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);
	
	@Query(value = "SELECT *FROM question q where q.category =:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
	List<Question> findRandomQuestionByCategory(String category,int numQ);
}
