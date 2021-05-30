package com.covid.backend.controller.hospital;

import com.covid.backend.pojo.Hospital;
import com.covid.backend.service.hospital.DeleteHospitalService;
import com.covid.backend.service.hospital.GetHospitalInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteHospital {

    @Autowired
    public DeleteHospitalService deleteHospitalService;
    @Autowired
    public GetHospitalInfoService getHospitalInfoService;

    @GetMapping("/hospital/deleteHospitalById")
    public Result deleteHospitalById(@RequestParam(value = "hospital_id") long hospital_id) {
        //TODO login check

        Hospital hospital = getHospitalInfoService.getHospitalInfoById(hospital_id);
        if (hospital == null) return Result.error("hospital not found");

        int affectedLine = deleteHospitalService.deleteHospitalById(hospital_id);
        return Result.ok(affectedLine);
    }

}
