package com.rest.api.dto.user;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class RequestUserDto {
	@NonNull
    private String name;
	@NonNull
    private String email;
	@NonNull
    private String password;
	@NonNull
    private List<RequestPhonesDto> phones;
}
