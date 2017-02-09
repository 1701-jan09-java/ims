package com.example.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class RestAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="/flashcard")
	public FlashCard getFlashCard() {
		FlashCard flashcard = new FlashCard("What's the meaning of life", "42");
		return flashcard;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/flashcard2")
	public ResponseEntity<FlashCard> getFlashCard2() {
		FlashCard flashcard = new FlashCard("What's the meaning of life", "42");
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(flashcard);
	}
		
}
