package com.rest.api.dto.user;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RequestUserDto {
	@NonNull
	@Size(min =0,max = 10, message="La longitud no es correcta")
    private String name;
	@NonNull
    private String email;
	@NonNull
    private String password;
	@NonNull
    private List<RequestPhonesDto> phones;
}
