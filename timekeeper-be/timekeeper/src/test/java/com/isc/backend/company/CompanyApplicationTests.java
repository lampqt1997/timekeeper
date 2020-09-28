package com.isc.backend.company;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class CompanyApplicationTests {

	@Test
	void contextLoads() {
		LocalDate date = LocalDate.of(2020,9,12);
		System.out.println(date);
		
	}

}
