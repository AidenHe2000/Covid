package com.covid.backend.controller.patient;

import com.covid.backend.pojo.Patient;
import com.covid.backend.service.patient.GetPatientInfoService;
import com.covid.backend.service.patient.UpdatePatientService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePatient {
    @Autowired
    public UpdatePatientService updatePatientService;
    @Autowired
    public GetPatientInfoService getPatientInfoService;

    @GetMapping("/patient/updatePatient")
    public Result updatePatient(@RequestParam(value = "patient_id") long patient_id,
                                @RequestParam(value = "patient_name", required = false) String patient_name,
                                @RequestParam(value = "patient_gender", required = false) String patient_gender,
                                @RequestParam(value = "patient_birthday", required = false) String patient_birthday,
                                @RequestParam(value = "onset_place", required = false) String onset_place,
                                @RequestParam(value = "onset_date", required = false) String onset_date,
                                @RequestParam(value = "confirm_date", required = false) String confirm_date,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "doctor_id") String doctor_id,
                                @RequestParam(value = "hospital_id") String hospital_id,
                                @RequestParam(value = "is_doctor", required = false) String is_doctor) {
        //TODO login check

        Patient patient = getPatientInfoService.getPatientInfoById(patient_id);
        if (patient == null) return Result.error("patient not found");
        int affectedLine = updatePatientService.UpdatePatient(patient_id, patient_name, patient_gender, patient_birthday, onset_place, onset_date, confirm_date, status, doctor_id, hospital_id, is_doctor);
        return Result.ok(affectedLine);
    }
}
