package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.AppPhones;

public interface PhoneRepository extends JpaRepository<AppPhones, Integer> {

}
