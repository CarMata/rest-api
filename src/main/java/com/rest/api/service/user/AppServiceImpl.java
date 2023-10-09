package com.rest.api.service.user;

import com.rest.api.dto.generic.GenericDto;
import com.rest.api.dto.user.RequestUserDto;
import com.rest.api.entity.AppUsers;

//@Service
//@RequiredArgsConstructor
public class AppServiceImpl implements AppService{
//	private final UsersRepository usersRepository;
//	private final PhoneRepository phoneRepository;
//	@Override
	public GenericDto<?> executeSaveUser(RequestUserDto request, String serviceName) {
		try {
			AppUsers entity = new AppUsers();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
