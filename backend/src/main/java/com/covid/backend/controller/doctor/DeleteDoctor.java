package com.covid.backend.controller.doctor;

import com.covid.backend.pojo.Doctor;
import com.covid.backend.service.doctor.DeleteDoctorService;
import com.covid.backend.service.doctor.GetDoctorInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteDoctor {
    @Autowired
    public DeleteDoctorService deleteDoctorService;
    @Autowired
    public GetDoctorInfoService getDoctorInfoService;

    @GetMapping("/doctor/deleteDoctorById")
    public Result deleteDoctorById(@RequestParam(value = "doctor_id") long doctor_id) {
        //TODO login check

        Doctor old = getDoctorInfoService.getDoctorInfoById(doctor_id);
        if (old == null) return Result.error("doctor not found");
        int affectedLine = deleteDoctorService.deleteDoctorById(doctor_id);
        return Result.ok(affectedLine);
    }
}
