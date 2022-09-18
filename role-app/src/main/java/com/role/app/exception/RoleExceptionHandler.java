package com.role.app.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.role.app.domain.Notification;
import com.role.app.util.RoleHelper;

@RestControllerAdvice
public class RoleExceptionHandler {
	@Autowired
	private RoleHelper roleHelper;
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Notification> methodNotAllowedExceptionCase(HttpRequestMethodNotSupportedException exception, HttpServletRequest request){
		Notification notification = roleHelper.buildNotification(exception.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.value(),
				HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), 
				request.getRequestURI());
		return new ResponseEntity<>(notification, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Notification> nullPointerException(NullPointerException exception, HttpServletRequest request){
		Notification notification = roleHelper.buildNotification(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), request.getRequestURI());
		return new ResponseEntity<>(notification, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> clientErrorException(MethodArgumentNotValidException exception, HttpServletRequest request){
		List<FieldError> fieldErrors = exception.getFieldErrors();
		Map<String, Object> map = new HashMap<>();
		for(FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}		
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Notification> exception(Exception exception, HttpServletRequest request){
		Notification notification = roleHelper.buildNotification(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
				request.getRequestURI());
		return new ResponseEntity<>(notification, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
