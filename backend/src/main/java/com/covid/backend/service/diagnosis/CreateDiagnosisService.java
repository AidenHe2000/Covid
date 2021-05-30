package com.covid.backend.service.diagnosis;

import com.covid.backend.pojo.Diagnosis;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CreateDiagnosisService extends BaseService {

    //TODO login check

    public int createDiagnosis(Diagnosis diagnosis) {
        return diagnosisMapper.insertDiagnosis(diagnosis);
    }
}
