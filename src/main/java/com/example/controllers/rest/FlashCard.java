package com.example.controllers.rest;

public class FlashCard {
	private String question;
	private String answer;
	public FlashCard(){}
	public FlashCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
}
