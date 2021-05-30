package com.covid.backend.service.diagnosis;

import com.covid.backend.pojo.Diagnosis;
import com.covid.backend.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDiagnosisService extends BaseService {

    @Autowired
    public GetDiagnosisService getDiagnosisService;

    //TODO login check

    public int updateDiagnosis(Diagnosis diagnosis) {
        Diagnosis old = getDiagnosisService.getDiagnosisInfoById(diagnosis.getDiagnosis_id());
        old.setDiagnosis_id(diagnosis.getDiagnosis_id());
        old.setDoctor_id(diagnosis.getDoctor_id());
        old.setTime(diagnosis.getTime());
        old.setSymptom(diagnosis.getSymptom());
        old.setTemperature(diagnosis.getTemperature());
        diagnosis.setNucleic_acid(diagnosis.getNucleic_acid());
        return diagnosisMapper.updateDiagnosis(diagnosis);
    }
}
