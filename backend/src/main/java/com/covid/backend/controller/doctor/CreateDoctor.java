package com.covid.backend.controller.doctor;

import com.covid.backend.service.doctor.CreateDoctorService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateDoctor {

    @Autowired
    public CreateDoctorService createDoctorService;

    @GetMapping("/doctor/createDoctor")
    public Result createDoctor(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "gender", required = false) String gender,
                               @RequestParam(value = "birthday", required = false) String birthday,
                               @RequestParam(value = "department", required = false) String department,
                               @RequestParam(value = "hospital_id") String hospital_id) {
        //TODO login check

        int affectedLine = createDoctorService.createDoctor(name, gender, birthday, department, hospital_id);
        return Result.ok(affectedLine);
    }
}
