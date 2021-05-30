package com.covid.backend.controller.patient;

import com.covid.backend.pojo.Patient;
import com.covid.backend.service.patient.GetPatientInfoService;
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
public class GetPatientInfo {

    @Autowired
    public GetPatientInfoService getPatientInfoService;

    @GetMapping("/patient/getPatientInfoById")
    public Result<HashMap<String, String>> getPatientInfoById(@RequestParam(value = "patient_id") long patient_id) {
        HashMap<String, String> patient = getPatientInfoService.getDetailedPatientById(patient_id);
        if (patient == null) return Result.error("patient not found");
        return Result.ok(patient);
    }

    @GetMapping("/patient/getPatientInfo")
    public Result<List<Patient>> getPatientInfo(@RequestParam(value = "patient_name", required = false) String patient_name,
                                                @RequestParam(value = "gender", required = false) String gender,
                                                @RequestParam(value = "birthday", required = false) String birthday,
                                                @RequestParam(value = "onset_place", required = false) String onset_place,
                                                @RequestParam(value = "onset_date", required = false) String onset_date,
                                                @RequestParam(value = "confirm_date", required = false) String confirm_date,
                                                @RequestParam(value = "status", required = false) String status,
                                                @RequestParam(value = "doctor_id", required = false) String doctor_id,
                                                @RequestParam(value = "hospital_id", required = false) String hospital_id,
                                                @RequestParam(value = "is_doctor", required = false) String is_doctor,
                                                @RequestParam Integer page, // 分页
                                                @RequestParam Integer size) {
        Page<HashMap<String, String>> pageInfo = PageHelper.startPage(page, size);
        List<HashMap<String, String>> list = getPatientInfoService.getPatientInfo(patient_name, gender, birthday, onset_place, onset_date, confirm_date, status, doctor_id, hospital_id, is_doctor);
        if (list == null) return null;
        return Result.pagedOk(pageInfo, pageInfo.getTotal());
    }
}
