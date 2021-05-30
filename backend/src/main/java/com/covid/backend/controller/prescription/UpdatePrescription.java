package com.covid.backend.controller.prescription;

import com.covid.backend.pojo.Prescription;
import com.covid.backend.service.prescription.GetPrescriptionInfoService;
import com.covid.backend.service.prescription.UpdatePrescriptionService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePrescription {

    @Autowired
    public UpdatePrescriptionService updatePrescriptionService;
    @Autowired
    public GetPrescriptionInfoService getPrescriptionInfoService;

    @GetMapping("/prescription/updatePrescription")
    public Result updatePrescription(@RequestParam(value = "prescription_id") long prescription_id,
                                     @RequestParam(value = "patient_id") String patient_id,
                                     @RequestParam(value = "medicine_id") String medicine_id,
                                     @RequestParam(value = "dosage", required = false) String dosage,
                                     @RequestParam(value = "usage", required = false) String usage,
                                     @RequestParam(value = "doctor_id") String doctor_id,
                                     @RequestParam(value = "prescription_date", required = false) String prescription_date) {
        //TODO login check

        Prescription prescription = getPrescriptionInfoService.getPrescriptionById(prescription_id);
        if (prescription == null) return Result.error("prescription not found");

        int affectedLine = updatePrescriptionService.updatePrescription(prescription_id, patient_id, medicine_id, dosage, usage, doctor_id, prescription_date);
        return Result.ok(affectedLine);
    }
}
