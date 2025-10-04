package com.example.hospital_management;

import com.example.hospital_management.entity.BloodGroupType;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HospitalManagementApplicationTests {

	@Test
	void contextLoads() {
		//just a basic function
	}

	@Autowired
	private PatientRepository patientRepository;

//	@Transactional
	@Test
	void testingDBConnection(){
		List<Patient> l = patientRepository.findByName("manveer");
		System.out.println(l);

		List<Patient> l2 = patientRepository.findByBirthDateOrEmail(LocalDate.parse("2002-03-16"),"manveer@gmail.com");
		System.out.println(l2);

		List<Patient> l3 = patientRepository.findByNameContaining("Ran");
		System.out.println(l3);

		List<Patient> l4 = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

		for(Patient p: l4){
			System.out.println(p);
		}

		List<Patient> l5 = patientRepository.findByBornAfterDate(LocalDate.parse("2002-09-18"));

		for(Patient p : l5){
			System.out.println(p);
		}

		List<Object[]> l6 = patientRepository.countEachBloodGroupType();

		for(Object[] o :l6){
			System.out.println(Arrays.toString(o));
		}

		List<Patient> l7 = patientRepository.findAllPatients();

		for(Patient p : l7){
			System.out.println(p);
		}
		int rowsUpdated = patientRepository.updateNameWithId("Majnu",6L);

		System.out.println(rowsUpdated);


	}

}
