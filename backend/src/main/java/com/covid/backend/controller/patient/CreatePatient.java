package com.covid.backend.controller.patient;

import com.covid.backend.service.patient.CreatePatientService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreatePatient {
    @Autowired
    public CreatePatientService createPatientService;

    @GetMapping("/patient/createPatient")
    public Result createPatient(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "gender", required = false) String gender,
                                @RequestParam(value = "birthday", required = false) String birthday,
                                @RequestParam(value = "onset_place", required = false) String onset_place,
                                @RequestParam(value = "onset_date", required = false) String onset_date,
                                @RequestParam(value = "confirm_date", required = false) String confirm_date,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "doctor_id") String doctor_id,
                                @RequestParam(value = "hospital_id") String hospital_id,
                                @RequestParam(value = "is_doctor", required = false) String is_doctor) {
        //TODO login check

        int affectedLine = createPatientService.createPatient(name, gender, birthday, onset_place, onset_date, confirm_date, status, doctor_id, hospital_id, is_doctor);
        return Result.ok(affectedLine);
    }
}
