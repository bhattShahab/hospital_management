package com.example.hospital_management.repository;

import com.example.hospital_management.entity.BloodGroupType;
import com.example.hospital_management.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate date, String email);

    List<Patient> findByNameContaining(String ran);

    @Query("select p from Patient p where p.bloodGroup=?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroupType);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select p.bloodGroup , count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional //need to use Transactional with Modifying
    @Modifying
    @Query(value="UPDATE patient SET name = :name WHERE id = :id",nativeQuery = true)
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
}
