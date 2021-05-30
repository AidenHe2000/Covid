package com.covid.backend.pojo;

import lombok.Data;

@Data
public class Prescription {
    private long prescription_id;
    private String patient_id;
    private String medicine_id;
    private String dosage;
    private String usage;
    private String doctor_id;
    private String prescription_date;
}
