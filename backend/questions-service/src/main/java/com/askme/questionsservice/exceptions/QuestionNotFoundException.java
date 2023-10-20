package com.askme.questionsservice.exceptions;

public class QuestionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3821570190685490193L;

	public QuestionNotFoundException(String message) {
		super(message);
	}

}
