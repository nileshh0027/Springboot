package com.QuestionQuiz.QuestionQuiz.ServicePkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuestionQuiz.QuestionQuiz.DaoPkg.QuestionRepo;
import com.QuestionQuiz.QuestionQuiz.Question;

import java.util.List;
@Service
public class QuestionService {

	@Autowired
	QuestionRepo repo;
	
	
	public List<Question> getAllQuestion()
	{
		return repo.findAll();
	}
	
	public List<Question> getByCategory(String category)
	{
		return repo.findByCategory(category);
	}
}
