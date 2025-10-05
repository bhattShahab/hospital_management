package com.example.hospital_management.service;

import com.example.hospital_management.entity.Insurance;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.InsuranceRepository;
import com.example.hospital_management.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance , Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional consistency

        return patient;
    }
}
