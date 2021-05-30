package com.covid.backend.controller.prescription;

import com.covid.backend.service.prescription.CreatePrescriptionService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreatePrescription {

    @Autowired
    public CreatePrescriptionService createPrescriptionService;

    @GetMapping("/prescription/createPrescription")
    public Result createPrescription(@RequestParam(value = "patient_id") String patient_id,
                                     @RequestParam(value = "medicine_id") String medicine_id,
                                     @RequestParam(value = "doctor_id") String doctor_id,
                                     @RequestParam(value = "dosage", required = false) String dosage,
                                     @RequestParam(value = "usage", required = false) String usage,
                                     @RequestParam(value = "prescription_date", required = false) String prescription_date) {

        //TODO login check

        int affectedLine = createPrescriptionService.createPrescription(patient_id, medicine_id, doctor_id, dosage, usage, prescription_date);

        return Result.ok(affectedLine);
    }
}
