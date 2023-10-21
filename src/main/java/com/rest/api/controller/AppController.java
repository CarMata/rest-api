package com.rest.api.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.dto.generic.GenericResponseDto;
import com.rest.api.dto.user.RequestUserDto;
import com.rest.api.dto.user.ResponseUserDto;
import com.rest.api.service.user.AppService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name ="AppController", description = "users rest-api")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AppController {
	
	private final AppService appService;
	@PostMapping(value = "/create-user",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDto<ResponseUserDto>> saveUsr(@Valid @RequestBody  RequestUserDto request) {
		String serviceName ="create-user";
		log.info(serviceName+" - RequestApi -> {}",request);
		GenericResponseDto<ResponseUserDto> response=appService.executeSaveUser(request, serviceName);
		log.info(serviceName+" - ResponseApi -> {}",response.getMessage());
		return ResponseEntity.status(response.getCode()).body(response);

	}
}
