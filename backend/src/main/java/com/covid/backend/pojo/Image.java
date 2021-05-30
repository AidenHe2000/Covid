package com.covid.backend.pojo;

import lombok.Data;

@Data
public class Image {
    private long image_id;
    private String patient_id;
    private String doctor_id;
    private String image_picture;
    private String conclusion;
    private String conclusion_doctor_id;
    private String scanning_doctor_id;
}
