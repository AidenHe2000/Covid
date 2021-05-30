package com.covid.backend.controller.prescription;

import com.covid.backend.pojo.Prescription;
import com.covid.backend.service.prescription.GetPrescriptionInfoService;
import com.covid.backend.utils.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class GetPrescriptionInfo {

    @Autowired
    public GetPrescriptionInfoService getPrescriptionInfoService;

    @GetMapping("/prescription/getPrescriptionInfoById")
    public Result<Prescription> getPrescriptionById(@RequestParam(value = "prescription_id") long prescription_id) {
        Prescription prescription = getPrescriptionInfoService.getPrescriptionById(prescription_id);
        if (prescription == null) return Result.error("prescription not found");
        return Result.ok(prescription);
    }

    @GetMapping("/prescription/getPrescriptionNumber")
    public Result<Prescription> getPrescriptionNumber() {
        return Result.ok(getPrescriptionInfoService.getPrescriptionNumber());
    }

    @GetMapping("/prescription/getDetailedPrescriptionInfoByPatientId")
    public Result<Prescription> getDetailedPrescriptionByPatientId(@RequestParam(value = "patient_id") String patient_id) {
        List<HashMap<String, String>> list = getPrescriptionInfoService.getDetailedPrescriptionByPatientId(patient_id);
        if (list == null) return Result.error("prescription not found");
        return Result.ok(list);
    }

    @GetMapping("/prescription/getPrescriptionInfo")
    public Result<List<Prescription>> getPrescriptionInfo(@RequestParam(value = "patient_id") String patient_id,
                                                          @RequestParam(value = "medicine_id") String medicine_id,
                                                          @RequestParam(value = "dosage", required = false) String dosage,
                                                          @RequestParam(value = "usage", required = false) String usage,
                                                          @RequestParam(value = "doctor_id", required = false) String doctor_id,
                                                          @RequestParam(value = "prescription_date", required = false) String prescription_date,
                                                          @RequestParam Integer page, // 分页
                                                          @RequestParam Integer size) {
        Page<HashMap<String, String>> pageInfo = PageHelper.startPage(page, size);
        List<Prescription> list = getPrescriptionInfoService.getPrescriptionInfo(patient_id, medicine_id, dosage, usage, doctor_id, prescription_date);
        if (list == null) return null;
        return Result.pagedOk(pageInfo);
    }

    @GetMapping("/prescription/getPrescriptionInfoByPatientId")
    public Result<List<Prescription>> getPrescriptionByPatientId(@RequestParam(value = "patient_id") String patient_id,
                                                                 @RequestParam Integer page, // 分页
                                                                 @RequestParam Integer size) {
        Page<HashMap<String, String>> pageInfo = PageHelper.startPage(page, size);
        List<Prescription> list = getPrescriptionInfoService.getPrescriptionByPatientId(patient_id);
        if (list == null) return null;
        return Result.pagedOk(pageInfo);
    }
}
