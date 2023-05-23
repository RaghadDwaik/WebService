package com.example.Assignment.Dto;

import lombok.Data;

/**
 * Author: Mohammed Kharma
 */
@Data
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields

public class DoctorDto {
    private int DoctorId;


    private String DoctorName;

    private String Address;

    private int tel;

    private String Status;


}
