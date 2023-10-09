package com.rest.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.dto.user.RequestUserDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name ="AppController", description = "users rest-api")
@RestController
@Slf4j
public class AppController {

	@PostMapping(value = "/create-user",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUsr(@RequestBody RequestUserDto request) {
		String serviceName ="create-user";
		log.info(serviceName+" - RequestApi -> {}",request);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
