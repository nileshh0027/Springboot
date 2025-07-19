package com.QuestionQuiz.QuestionQuiz;

public class Response {
	
	private int id;
	private String response;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponses(String responses) {
		this.response = responses;
	}
	public Response(int id, String responses) {
		super();
		this.id = id;
		this.response = responses;
	}
	
	

}
