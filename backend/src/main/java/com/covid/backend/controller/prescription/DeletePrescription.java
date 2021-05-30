package com.covid.backend.controller.prescription;

import com.covid.backend.pojo.Prescription;
import com.covid.backend.service.prescription.DeletePrescriptionService;
import com.covid.backend.service.prescription.GetPrescriptionInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePrescription {

    @Autowired
    public DeletePrescriptionService deletePrescriptionService;
    @Autowired
    public GetPrescriptionInfoService getPrescriptionInfoService;

    @GetMapping("/prescription/deletePrescriptionById")
    public Result deletePrescriptionById(@RequestParam(value = "prescription_id") long prescription_id) {
        //TODO login check

        Prescription prescription = getPrescriptionInfoService.getPrescriptionById(prescription_id);
        if (prescription == null) return Result.error("prescription not found");

        int affectedLine = deletePrescriptionService.deletePrescriptionById(prescription_id);
        return Result.ok(affectedLine);
    }
}
