package com.askme.commentsservice.controllers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.askme.commentsservice.dto.ExceptionResponse;
import com.askme.commentsservice.exceptions.CommentNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(value = CommentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleCommentNotFoundException(CommentNotFoundException exception,WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setError(exception.getMessage());
		exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
		exceptionResponse.setTimestamp(LocalDate.now().toString());
		exceptionResponse.setPath(request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
}
