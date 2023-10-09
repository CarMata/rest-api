package com.rest.api.service.user;

import com.rest.api.dto.generic.GenericDto;
import com.rest.api.dto.user.RequestUserDto;

public interface AppService {

	GenericDto<?> executeSaveUser(RequestUserDto request, String serviceName);
}
