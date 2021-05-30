package com.covid.backend.service;

import com.covid.backend.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseService {

    @Autowired
    public MedicineMapper medicineMapper;

    @Autowired
    public HospitalMapper hospitalMapper;

    @Autowired
    public DoctorMapper doctorMapper;

    @Autowired
    public PatientMapper patientMapper;

    @Autowired
    public DiagnosisMapper diagnosisMapper;

    @Autowired
    public PrescriptionMapper prescriptionMapper;

    @Autowired
    public ImageMapper imageMapper;
}
