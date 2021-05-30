package com.covid.backend.pojo;

import lombok.Data;

@Data
public class Patient {

    private long patient_id;
    private String patient_name;
    private String doctor_id;
    private String hospital_id;
    private String patient_gender;
    private String patient_birthday;
    private String onset_place;
    private String onset_date;
    private String confirm_date;
    private String status;
    private String is_doctor;
}
