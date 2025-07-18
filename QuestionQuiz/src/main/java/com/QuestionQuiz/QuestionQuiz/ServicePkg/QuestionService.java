package com.QuestionQuiz.QuestionQuiz.ServicePkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.QuestionQuiz.QuestionQuiz.DaoPkg.QuestionRepo;
import com.QuestionQuiz.QuestionQuiz.Question;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService {

	@Autowired
	QuestionRepo repo;
	
	
	public ResponseEntity<List<Question>> getAllQuestion()
	{
		try {
			return	new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getByCategory(String category)
	{
		try {
			return	new ResponseEntity<>(repo.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	@Transactional
	public ResponseEntity<String> addQuestion(Question question)
	{
		try {
			repo.save(question);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("Fail",HttpStatus.BAD_REQUEST);
	}
}
