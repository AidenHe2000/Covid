package com.covid.backend.controller.hospital;

import com.covid.backend.pojo.Hospital;
import com.covid.backend.service.hospital.GetHospitalInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetHospitalInfo {

    @Autowired
    public GetHospitalInfoService getHospitalInfoService;

    @GetMapping("/hospital/getHospitalInfoById")
    public Result<Hospital> getHospitalById(@RequestParam(value = "hospital_id") long hospital_id) {
        Hospital hospital = getHospitalInfoService.getHospitalInfoById(hospital_id);
        if (hospital == null) return Result.error("hospital not found");
        return Result.ok(hospital);
    }

    @GetMapping("/hospital/getHospitalInfo")
    public Result<List<Hospital>> getHospitalInfo(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "address", required = false) String address) {
        Hospital hospital = new Hospital();
        hospital.setHospital_name(name);
        hospital.setAddress(address);

        List<Hospital> hospitals = getHospitalInfoService.getHospital(hospital);
        if (hospitals == null) return null;
        return Result.ok(hospitals);
    }
}
