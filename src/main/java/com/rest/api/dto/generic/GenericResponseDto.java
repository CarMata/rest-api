package com.rest.api.dto.generic;

import lombok.Data;

@Data
public class GenericResponseDto<T> {

	private T item;
	private String message;
	private Integer code;
}
