package com.example.hospital_management.repository;

import com.example.hospital_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate date, String email);

    List<Patient> findByNameContaining(String ran);
}
