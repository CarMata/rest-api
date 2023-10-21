package com.service.restapi.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.rest.api.Application;
import com.rest.api.controller.AppController;
import com.rest.api.dto.generic.GenericResponseDto;
import com.rest.api.dto.user.RequestUserDto;
import com.rest.api.dto.user.ResponseUserDto;
import com.rest.api.service.user.AppService;

@SpringBootTest(classes =Application.class)
class AppControllerTest {

	@InjectMocks
	private AppController appController;
	
	@Mock
	private AppService appService;
	
	@Test
	@Order(1)
	@DisplayName("should return Success")
	void saveDataOkTest() {
		
		RequestUserDto request = new RequestUserDto();
		
		GenericResponseDto<ResponseUserDto> response = new GenericResponseDto<>();
		response.setMessage(HttpStatus.OK.getReasonPhrase());
		response.setCode(HttpStatus.OK.value());		
		
		when(appService.executeSaveUser(request,"create-user")).thenReturn(response);
		
		var apiResponse = appController.saveUsr(request);
		
		GenericResponseDto<ResponseUserDto> genericResponse = apiResponse.getBody();
		
		assertNotNull(genericResponse);
		assertTrue(genericResponse.getMessage().contentEquals(HttpStatus.OK.getReasonPhrase()));
		
	}
	
	@Test
	@Order(2)
	@DisplayName("should return error")
	void saveDataErrorTest() {
		
		RequestUserDto request = new RequestUserDto();
		
		GenericResponseDto<ResponseUserDto> response = new GenericResponseDto<>();
		response.setMessage(HttpStatus.CONFLICT.getReasonPhrase());
		response.setCode(HttpStatus.CONFLICT.value());		
		
		when(appService.executeSaveUser(request,"create-user")).thenReturn(response);
		
		var apiResponse = appController.saveUsr(request);
		
		GenericResponseDto<ResponseUserDto> genericResponse = apiResponse.getBody();
		
		assertNotNull(genericResponse);
		assertTrue(genericResponse.getMessage().contentEquals(HttpStatus.CONFLICT.getReasonPhrase()));
		
	}
	
}
