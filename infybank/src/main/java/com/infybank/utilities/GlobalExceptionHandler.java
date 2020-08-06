package com.infybank.utilities;


import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.infybank.exceptions.InfyBankBranchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	Environment environment;
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception e){
		logger.error(e.getMessage(), e);
		
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMessage(environment.getProperty("general.exception.message"));
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InfyBankBranchException.class)
	public ResponseEntity<ErrorInfo> infyBankBranchExceptionHandler(InfyBankBranchException e){
		logger.error(e.getMessage(), e);
		
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(environment.getProperty(e.getMessage()));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception e){
		
		String errorMsg;
		
		if(e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException) e;
			errorMsg = manve.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(", "));
		}
		else {
			ConstraintViolationException cve = (ConstraintViolationException) e;
			errorMsg = cve.getConstraintViolations().stream().map(x -> x.getMessage()).collect(Collectors.joining(", "));
		}
		
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(errorMsg);
		
		
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.BAD_REQUEST);
	}

}
