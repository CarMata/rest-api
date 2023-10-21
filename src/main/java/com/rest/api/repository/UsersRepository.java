package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.AppUsers;

public interface UsersRepository extends JpaRepository<AppUsers, String> {

}
