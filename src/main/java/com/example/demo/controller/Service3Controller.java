package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Name;

@RestController
@RequestMapping("/serv3")
public class Service3Controller {
	@PostMapping()
	public ResponseEntity<String> service3(@RequestBody @Valid Name name) {
		return ResponseEntity.ok(name.getName()+" "+name.getSurname());
	}
}
