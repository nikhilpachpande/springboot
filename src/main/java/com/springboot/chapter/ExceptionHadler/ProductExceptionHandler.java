package com.springboot.chapter.ExceptionHadler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String productException(Exception e) {
		
		
		return e.getMessage();
		
		
		
	}

}
