package com.projectposter.Advice;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.projectposter.Error.ErrorMessage;
import com.projectposter.Exceptions.PosterNotUpdatedException;
import com.projectposter.Exceptions.PostingNotFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionCentral {

@Autowired
	ErrorMessage error;
	
	@ExceptionHandler(PostingNotFoundException.class)
	public ResponseEntity<ErrorMessage> postingNotFound(PostingNotFoundException ex)
	{
	
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		return ResponseEntity.ok(error);
	}
	
	@ExceptionHandler(PosterNotUpdatedException.class)
	public ResponseEntity<ErrorMessage> posternotupdated(PosterNotUpdatedException ex)
	{
		error.setErrorCode(HttpStatus.NOT_MODIFIED.value());
		error.setErrorMessage(ex.getMessage());
		return ResponseEntity.ok(error);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> MethodArgumentNotValid(MethodArgumentNotValidException exception)
	{
		error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		error.setErrorMessage(
				exception.getAllErrors().stream().map(
						exceptions -> exceptions.getDefaultMessage().toString()
						).collect(Collectors.joining(","))
				);
		return ResponseEntity.ok(error);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> ConstraintViolation(ConstraintViolationException exception)
	{
		error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		error.setErrorMessage(
				exception.getConstraintViolations().stream().map(
						exceptions -> exceptions.getMessage()
						).collect(Collectors.joining(","))
				);
		return ResponseEntity.ok(error);
	}
}

