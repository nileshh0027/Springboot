package com.QuestionQuiz.QuestionQuiz.ServicePkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.QuestionQuiz.QuestionQuiz.Question;
import com.QuestionQuiz.QuestionQuiz.QuestionWrapper;
import com.QuestionQuiz.QuestionQuiz.Quiz;
import com.QuestionQuiz.QuestionQuiz.DaoPkg.QuestionRepo;
import com.QuestionQuiz.QuestionQuiz.DaoPkg.QuizDao;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionRepo questionRepo;
	public ResponseEntity<String> createQuiz(String category,int numQ,String title)
	{
		try {
			List<Question> question = questionRepo.findRandomQuestionByCategory(category,numQ);
			
			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestion(question);
			quizDao.save(quiz);
			
			return new ResponseEntity<>("Successfully created",HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionFromDB = quiz.get().getQuestion();
		List<QuestionWrapper> questionForUsers = new ArrayList<>();
		for(Question q : questionFromDB)
		{
			questionForUsers.add(new QuestionWrapper(q.getId(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), q.getQuestionTitle()));
		}
		
		return new ResponseEntity<>(questionForUsers,HttpStatus.OK);
		
		
	}
}
