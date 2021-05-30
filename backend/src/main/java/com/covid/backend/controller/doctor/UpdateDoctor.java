package com.covid.backend.controller.doctor;

import com.covid.backend.pojo.Doctor;
import com.covid.backend.service.doctor.GetDoctorInfoService;
import com.covid.backend.service.doctor.UpdateDoctorService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateDoctor {

    @Autowired
    public UpdateDoctorService updateDoctorService;
    @Autowired
    public GetDoctorInfoService getDoctorInfoService;

    @GetMapping("/doctor/updateDoctor")
    public Result updateDoctor(@RequestParam(value = "doctor_id") long doctor_id,
                               @RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "gender", required = false) String gender,
                               @RequestParam(value = "birthday", required = false) String birthday,
                               @RequestParam(value = "department", required = false) String department,
                               @RequestParam(value = "hospital_id") String hospital_id) {
        //TODO login check
        Doctor old = getDoctorInfoService.getDoctorInfoById(doctor_id);
        if (old == null) return Result.error("doctor not found");
        int affectedLine = updateDoctorService.updateDoctor(doctor_id, name, gender, birthday, department, hospital_id);
        return Result.ok(affectedLine);
    }
}
