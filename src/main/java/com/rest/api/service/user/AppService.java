package com.rest.api.service.user;

import com.rest.api.dto.generic.GenericResponseDto;
import com.rest.api.dto.user.RequestUserDto;
import com.rest.api.dto.user.ResponseUserDto;

public interface AppService {

	GenericResponseDto<ResponseUserDto> executeSaveUser(RequestUserDto request, String serviceName);
}
