package com.covid.backend.pojo;

import lombok.Data;

@Data
public class Medicine {
    private long medicine_id;
    private String medicine_name;
    private String manufacturer;
    private String introduction;
    private String type;
}
