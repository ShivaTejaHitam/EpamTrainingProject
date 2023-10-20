package com.askme.commentsservice.exceptions;

public class CommentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 360255842945221230L;
	
	public CommentNotFoundException(String message) {
		super(message);
	}

}
