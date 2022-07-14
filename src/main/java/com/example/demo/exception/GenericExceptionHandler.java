package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GenericExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	  public ResponseEntity handleMethodArgumentNotValid(Exception ex) {
	    StringBuilder sb = new StringBuilder();
	    Map<String, String> resultMap = new HashMap<>();
	    if(ex instanceof MethodArgumentNotValidException) {
	    	for(ObjectError error : ((MethodArgumentNotValidException)ex).getBindingResult().getAllErrors()) {
	    		resultMap.put("Message", error.getDefaultMessage()+" ");
	    		resultMap.put("Reason", error.getCode());
	    	}	    	
	    } else {
	    	resultMap.put("Message", ex.getMessage());
    		resultMap.put("Reason", ex.getClass().getName());
	    }
	    	
	    return ResponseEntity.badRequest().body(resultMap);
	  }
}
