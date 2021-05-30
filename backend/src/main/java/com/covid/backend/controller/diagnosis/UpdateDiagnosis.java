package com.covid.backend.controller.diagnosis;

import com.covid.backend.pojo.Diagnosis;
import com.covid.backend.service.diagnosis.GetDiagnosisService;
import com.covid.backend.service.diagnosis.UpdateDiagnosisService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateDiagnosis {

    @Autowired
    public UpdateDiagnosisService updateDiagnosisService;
    @Autowired
    public GetDiagnosisService getDiagnosisService;

    @GetMapping("/diagnosis/updateDiagnosis")
    public Result updateDiagnosis(@RequestParam(value = "diagnosis_id") long diagnosis_id,
                                  @RequestParam(value = "patient_id") String patient_id,
                                  @RequestParam(value = "doctor_id") String doctor_id,
                                  @RequestParam(value = "time", required = false) String time,
                                  @RequestParam(value = "symptom", required = false) String symptom,
                                  @RequestParam(value = "temperature", required = false) String temperature,
                                  @RequestParam(value = "nucleic_acid", required = false) String nucleic_acid) {
        //TODO login check

        Diagnosis diagnosis = getDiagnosisService.getDiagnosisInfoById(diagnosis_id);
        if (diagnosis == null) return Result.error("diagnosis not found");
        diagnosis.setPatient_id(patient_id);
        diagnosis.setDoctor_id(doctor_id);
        diagnosis.setTime(time);
        diagnosis.setSymptom(symptom);
        diagnosis.setTemperature(temperature);
        diagnosis.setNucleic_acid(nucleic_acid);

        int affectedLines = updateDiagnosisService.updateDiagnosis(diagnosis);
        return Result.ok(affectedLines);
    }
}
