package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Name;

@RestController
@RequestMapping("/serv1")
@Validated
public class Service1Controller {
	@Value("${url}")
	String url;
	@GetMapping()
	public ResponseEntity<String> checkServIsUp() {
		return ResponseEntity.ok("Up");
	}
	
	@PostMapping()
	public ResponseEntity<String> concatenatedResponse(@RequestBody @Valid Name name){
		RestTemplate restTemplate = new RestTemplate();
		String outputServ2 = restTemplate.getForObject(url+"/serv2", String.class);
		String outputServ3 = restTemplate.postForObject(url+"/serv3", name, String.class);
		return ResponseEntity.ok(outputServ2+" "+outputServ3);
	}
}
