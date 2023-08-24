package br.bosch.com.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.bosch.com.exceptions.ExceptionsResponse;

@RestControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionsResponse> handleAllExceptions(
			Exception ex, WebRequest request){
			ExceptionsResponse exptResponse = new ExceptionsResponse
					(new Date(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(exptResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedClassVersionError.class)
	public final ResponseEntity<ExceptionsResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request){
			
		ExceptionsResponse exptResponse = new ExceptionsResponse
					(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exptResponse, HttpStatus.BAD_REQUEST);
	}
	
}
