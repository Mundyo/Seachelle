package seachelle.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {
 
	 
	public Map<String, String> handleNoSuchElementException(
          NoSuchElementException ex){
		log.error("Exception: {}", ex.toString());
		return Map.of("message", ex.toString());
	}
}
