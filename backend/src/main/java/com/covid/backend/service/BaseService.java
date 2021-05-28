package com.covid.backend.service;

import com.covid.backend.dao.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseService {

    @Autowired
    public MedicineMapper medicineMapper;
}
