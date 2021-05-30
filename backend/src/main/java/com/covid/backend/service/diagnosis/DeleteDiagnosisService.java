package com.covid.backend.service.diagnosis;

import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DeleteDiagnosisService extends BaseService {

    //TODO login check

    public int deleteDiagnosisById(long diagnosis_id) {
        return diagnosisMapper.deleteDiagnosisById(diagnosis_id);
    }
}
