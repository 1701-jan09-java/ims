package com.ims.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllers.rest.FlashCard;

@RestController
@RequestMapping(value="/product")
public class ProductAPI {
	
	@RequestMapping(method=RequestMethod.GET, value="/get-product")
	public FlashCard getFlashCard() {
		FlashCard flashcard = new FlashCard("What's the meaning of life", "42");
		return flashcard;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/get-all-products")
	public ResponseEntity<FlashCard> getFlashCard2() {
		FlashCard flashcard = new FlashCard("What's the meaning of life", "42");
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(flashcard);
	}
		
}
