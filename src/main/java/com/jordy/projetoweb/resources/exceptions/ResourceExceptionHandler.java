package com.jordy.projetoweb.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jordy.projetoweb.services.exceptions.DatabaseException;
import com.jordy.projetoweb.services.exceptions.ResourceNotFoundException.ResourceNotFoundException;

@ControllerAdvice // intercepta as exceções para q o obj possa executar um possivel tratamento
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)// mostra qual exceção o método vai interceptar e vai tratar oq tiver dentro do metodo
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)// mostra qual exceção o método vai interceptar e vai tratar oq tiver dentro do metodo
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Database not found";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
