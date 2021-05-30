package com.covid.backend.controller.hospital;

import com.covid.backend.pojo.Hospital;
import com.covid.backend.service.hospital.CreateHospitalService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateHospital {

    @Autowired
    public CreateHospitalService createHospitalService;

    @GetMapping("/hospital/createHospital")
    public Result createHospital(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "address", required = false) String address) {
        //TODO login check

        Hospital hospital = new Hospital();
        hospital.setHospital_name(name);
        hospital.setAddress(address);

        int affectedLine = createHospitalService.createHospital(hospital);
        return Result.ok(affectedLine);
    }
}
