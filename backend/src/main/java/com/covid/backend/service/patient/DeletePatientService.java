package com.covid.backend.service.patient;

import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DeletePatientService extends BaseService {

    //TODO login check

    public int deletePatientById(long patient_id) {
        return patientMapper.deletePatientById(patient_id);
    }
}
