package com.example.hospital_management.dto;


import com.example.hospital_management.entity.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BloodGroupCountResponseType {
    private BloodGroupType bloodGroupType;
    private Long count;
}
