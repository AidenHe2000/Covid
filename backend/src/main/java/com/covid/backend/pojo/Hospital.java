package com.covid.backend.pojo;

import lombok.Data;

@Data
public class Hospital {
    private long hospital_id;
    private String hospital_name;
    private String address;
}
