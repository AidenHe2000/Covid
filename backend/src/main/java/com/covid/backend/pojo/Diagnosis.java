package com.covid.backend.pojo;

import lombok.Data;

@Data
public class Diagnosis {
    private long diagnosis_id;
    private String patient_id;
    private String doctor_id;
    private String time;
    private String symptom;
    private String temperature;
    private String nucleic_acid;
}
