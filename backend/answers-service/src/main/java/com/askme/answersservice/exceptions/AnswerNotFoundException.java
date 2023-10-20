package com.askme.answersservice.exceptions;

public class AnswerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -290863646571695192L;
	
	public AnswerNotFoundException(String message) {
		super(message);
	}
	
}
