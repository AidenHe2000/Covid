package com.covid.backend.controller.diagnosis;

import com.covid.backend.pojo.Diagnosis;
import com.covid.backend.service.diagnosis.DeleteDiagnosisService;
import com.covid.backend.service.diagnosis.GetDiagnosisService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteDiagnosis {

    @Autowired
    public DeleteDiagnosisService deleteDiagnosisService;
    @Autowired
    public GetDiagnosisService getDiagnosisService;

    @GetMapping("/diagnosis/deleteDiagnosisById")
    public Result deleteDiagnosisById(@RequestParam(value = "diagnosis_id") long diagnosis_id) {

        //TODO login check
        Diagnosis diagnosis = getDiagnosisService.getDiagnosisInfoById(diagnosis_id);
        if (diagnosis == null) return Result.error("diagnosis not found");

        int affectedLine = deleteDiagnosisService.deleteDiagnosisById(diagnosis_id);
        return Result.ok(affectedLine);
    }
}
