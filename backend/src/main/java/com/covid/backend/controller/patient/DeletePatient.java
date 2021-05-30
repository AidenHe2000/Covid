package com.covid.backend.controller.patient;

import com.covid.backend.pojo.Patient;
import com.covid.backend.service.patient.DeletePatientService;
import com.covid.backend.service.patient.GetPatientInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePatient {

    @Autowired
    public DeletePatientService deletePatientService;
    @Autowired
    public GetPatientInfoService getPatientInfoService;

    @GetMapping("/patient/deletePatientById")
    public Result deletePatientById(@RequestParam(value = "patient_id") long patient_id) {
        //TODO login check

        Patient patient = getPatientInfoService.getPatientInfoById(patient_id);
        if (patient == null) return Result.error("patient not found");
        int affectedLine = deletePatientService.deletePatientById(patient_id);
        return Result.ok(affectedLine);
    }
}
