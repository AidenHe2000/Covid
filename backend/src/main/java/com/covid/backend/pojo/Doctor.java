package com.covid.backend.pojo;

import lombok.Data;

@Data
public class Doctor {

    private long doctor_id;
    //in case of NULL
    private String hospital_id;
    private String doctor_name;
    private String doctor_gender;
    private String doctor_birthday;
    private String department;
}
