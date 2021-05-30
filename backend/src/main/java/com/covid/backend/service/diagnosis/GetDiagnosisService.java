package com.covid.backend.service.diagnosis;

import com.covid.backend.pojo.Diagnosis;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDiagnosisService extends BaseService {

    public Diagnosis getDiagnosisInfoById(long diagnosis_id) {
        return diagnosisMapper.selectDiagnosisById(diagnosis_id);
    }

    public Integer getDiagnosisNumber() {
        return diagnosisMapper.getNumber();
    }

    public List<Diagnosis> getDiagnosisInfo(Diagnosis diagnosis) {
        if(diagnosis.getPatient_id() == null) diagnosis.setPatient_id("%");
        if(diagnosis.getDoctor_id() == null) diagnosis.setDoctor_id("%");
        if(diagnosis.getTime() == null) diagnosis.setTime("%");
        if(diagnosis.getSymptom() == null) diagnosis.setSymptom("%");
        if(diagnosis.getTemperature() == null) diagnosis.setTemperature("%");
        if(diagnosis.getNucleic_acid() == null) diagnosis.setNucleic_acid("%");
        return diagnosisMapper.selectDiagnosis(diagnosis);
    }
}
