package com.covid.backend.controller.diagnosis;

import com.covid.backend.pojo.Diagnosis;
import com.covid.backend.service.diagnosis.GetDiagnosisService;
import com.covid.backend.utils.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetDiagnosisInfo {

    @Autowired
    public GetDiagnosisService getDiagnosisService;

    @GetMapping("/diagnosis/getDiagnosisInfoById")
    public Result<Diagnosis> getDiagnosisInfoById(@RequestParam(value = "diagnosis_id") long diagnosis_id) {
        Diagnosis diagnosis = getDiagnosisService.getDiagnosisInfoById(diagnosis_id);
        if (diagnosis == null) return Result.error("diagnosis not found");
        return Result.ok(diagnosis);
    }

    @GetMapping("/diagnosis/getDiagnosisNumber")
    public Result<Integer> getDiagnosisNumber() {
        return Result.ok(getDiagnosisService.getDiagnosisNumber());
    }

    @GetMapping("/diagnosis/getDiagnosisInfo")
    public Result<List<Diagnosis>> getDiagnosisInfo(@RequestParam(value = "patient_id", required = false) String patient_id,
                                                    @RequestParam(value = "doctor_id", required = false) String doctor_id,
                                                    @RequestParam(value = "time", required = false) String time,
                                                    @RequestParam(value = "symptom", required = false) String symptom,
                                                    @RequestParam(value = "temperature", required = false) String temperature,
                                                    @RequestParam(value = "nucleic_acid", required = false) String nucleic_acid,
                                                    @RequestParam Integer page, // 分页
                                                    @RequestParam Integer size) {
        Diagnosis diagnosis = new Diagnosis();
        Page<Diagnosis> pageInfo = PageHelper.startPage(page, size);
        diagnosis.setPatient_id(patient_id);
        diagnosis.setDoctor_id(doctor_id);
        diagnosis.setTime(time);
        diagnosis.setSymptom(symptom);
        diagnosis.setTemperature(temperature);
        diagnosis.setNucleic_acid(nucleic_acid);

        List<Diagnosis> list = getDiagnosisService.getDiagnosisInfo(diagnosis);
        if (list == null) return null;
        return Result.pagedOk(pageInfo, pageInfo.getTotal());
    }
}
