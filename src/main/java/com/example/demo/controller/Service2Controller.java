package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serv2")
public class Service2Controller {
	@GetMapping
	public ResponseEntity<String> service2(){
		return ResponseEntity.ok("Hello");
	}
}
