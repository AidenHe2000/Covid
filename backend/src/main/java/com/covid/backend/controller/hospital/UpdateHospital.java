package com.covid.backend.controller.hospital;

import com.covid.backend.pojo.Hospital;
import com.covid.backend.service.hospital.GetHospitalInfoService;
import com.covid.backend.service.hospital.UpdateHospitalService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateHospital {

    @Autowired
    public UpdateHospitalService updateHospitalService;
    @Autowired
    public GetHospitalInfoService getHospitalInfoService;

    @GetMapping("/hospital/updateHospital")
    public Result updateHospital(@RequestParam(value = "hospital_id") long hospital_id,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "address", required = false) String address) {
        //TODO login check

        Hospital old = getHospitalInfoService.getHospitalInfoById(hospital_id);
        if (old == null) return Result.error("hospital not found");

        Hospital hospital = new Hospital();
        hospital.setHospital_id(hospital_id);
        hospital.setHospital_name(name);
        hospital.setAddress(address);

        int affectedLine = updateHospitalService.updateHospital(hospital);
        return Result.ok(affectedLine);
    }
}
