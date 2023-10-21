package com.rest.api.service.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.api.dto.generic.GenericResponseDto;
import com.rest.api.dto.user.RequestPhonesDto;
import com.rest.api.dto.user.RequestUserDto;
import com.rest.api.dto.user.ResponseUserDto;
import com.rest.api.entity.AppPhones;
import com.rest.api.entity.AppUsers;
import com.rest.api.repository.UsersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppServiceImpl implements AppService {
	private final UsersRepository usersRepository;

	@Override
	public GenericResponseDto<ResponseUserDto> executeSaveUser(RequestUserDto request, String serviceName) {
		GenericResponseDto<ResponseUserDto> responseApi = new GenericResponseDto<>();
		try {
			String idUuid = UUID.randomUUID().toString().replaceAll("-", "");
			log.info(serviceName + " - Llenando entidad appUsers -> {}", idUuid);
			AppUsers entity = new AppUsers();
			entity.setUserId(idUuid);
			entity.setUserActive(Boolean.TRUE);
			entity.setUserToken(idUuid);
			entity.setUserName(request.getName());
			entity.setUserEmail(request.getEmail());
			entity.setUserPassword(request.getPassword());
			entity.setAppPhonesList(fillPhones(request.getPhones(), entity, serviceName));
			entity.setUserCreatedAt(new Date());
			log.info(serviceName + " - entidad llena -> {}", " appUsers");
			log.info(serviceName + " - Registrando datos -> {}", " usersRepository.save(entity)");
			entity = usersRepository.save(entity);
			log.info(serviceName + " - Datos registrados ");

			
			ResponseUserDto responseDto = fillResponse(entity);
			responseApi.setItem(responseDto);
			responseApi.setMessage(HttpStatus.OK.getReasonPhrase());
			responseApi.setCode(HttpStatus.OK.value());
		} catch (Exception e) {
			log.error(serviceName + " - Error registrando datos -> {}", e);
			e.printStackTrace();
			responseApi.setCode(HttpStatus.CONFLICT.value());
			responseApi.setMessage("Error registrando datos!");
		}
		return responseApi;
	}

	private List<AppPhones> fillPhones(List<RequestPhonesDto> phones, AppUsers usersEntity, String serviceName) {
		List<AppPhones> lst = new ArrayList<>();
		try {
			log.info(serviceName + " - Llenando entidad -> {}", "appPhones");
			for (RequestPhonesDto phone : phones) {
				AppPhones entity = new AppPhones();
				entity.setUserId(usersEntity);
				entity.setPhoneNumber(phone.getNumber());
				entity.setPhoneCitycode(phone.getCitycode());
				entity.setPhoneContrycode(phone.getContrycode());
				lst.add(entity);
			}
			log.info(serviceName + " - entidad llena -> {}", " appPhones");
		} catch (Exception e) {
			log.error(serviceName + " - Error llenando entidad phones -> {}", e);
			e.printStackTrace();
		}
		return lst;
	}

	private ResponseUserDto fillResponse(AppUsers entity) {
		ResponseUserDto responseDto = new ResponseUserDto();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYY HH:mm:ss");
		try {
			responseDto.setId(entity.getUserId());
			String created = sdf.format(entity.getUserCreatedAt());
			responseDto.setCreated(created);
			responseDto.setIsactive(entity.isUserActive());
			String lastLogin = entity.getUserLastLogin()!=null ? sdf.format(entity.getUserLastLogin()) :created;
			responseDto.setLast_login(lastLogin);
			responseDto.setToken(entity.getUserToken());
			
			String modified = entity.getUserModifieddAt()!=null ? sdf.format(entity.getUserModifieddAt()) :null;
			
			responseDto.setModified(modified);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseDto;
	}

}
