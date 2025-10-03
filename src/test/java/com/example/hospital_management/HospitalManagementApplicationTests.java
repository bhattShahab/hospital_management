package com.example.hospital_management;

import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HospitalManagementApplicationTests {

	@Test
	void contextLoads() {
		//just a basic function
	}

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void testingDBConnection(){
		List<Patient>l = patientRepository.findAll();
		System.out.println(l);
	}

}
