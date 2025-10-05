package com.example.hospital_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "patient")
public class Patient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;


    @OneToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="patient_insurance_id") //owning side
    private Insurance insurance;

    @ToString.Exclude
    @OneToMany(mappedBy = "patient") //Inverse side
    private List<Appointment> appointment;

}
