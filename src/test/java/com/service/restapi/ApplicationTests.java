package com.service.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.api.Application;

@SpringBootTest(classes =Application.class)
class ApplicationTests {

	@Test
	void contextLoads() {
		Application.main(new String[] {});
	}

}
