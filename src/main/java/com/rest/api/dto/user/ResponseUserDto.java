package com.rest.api.dto.user;

import lombok.Data;

@Data
public class ResponseUserDto {

	private String id;
	private String created;
	private String modified;
	private String last_login;
	private String token;
	private boolean isactive;
}
