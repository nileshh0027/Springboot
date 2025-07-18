package com.QuestionQuiz.QuestionQuiz.ControllerPkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.QuestionQuiz.QuestionQuiz.ServicePkg.QuestionService;
import com.QuestionQuiz.QuestionQuiz.Question;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@GetMapping("/allQuestion")
	public ResponseEntity<List<Question>> getData()
	{
		return service.getAllQuestion();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getByCategory(@PathVariable String category)
	{
		return service.getByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		return service.addQuestion(question);
	}
}
