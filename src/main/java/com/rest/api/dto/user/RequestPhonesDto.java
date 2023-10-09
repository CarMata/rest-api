package com.rest.api.dto.user;

import lombok.Data;

@Data
public class RequestPhonesDto {
	private String number;
	private String citycode;
	private String contrycode;
}
