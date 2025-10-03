package com.example.hospital_management;

import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
		List<Patient> l = patientRepository.findByName("manveer");
		System.out.println(l);

		List<Patient> l2 = patientRepository.findByBirthDateOrEmail(LocalDate.parse("2002-03-16"),"manveer@gmail.com");
		System.out.println(l2);

		List<Patient> l3 = patientRepository.findByNameContaining("Ran");
		System.out.println(l3);
	}

}
