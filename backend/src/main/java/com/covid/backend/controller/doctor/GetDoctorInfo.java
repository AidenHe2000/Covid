package com.covid.backend.controller.doctor;

import com.covid.backend.pojo.Doctor;
import com.covid.backend.service.doctor.GetDoctorInfoService;
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
public class GetDoctorInfo {

    @Autowired
    public GetDoctorInfoService getDoctorInfoService;

    @GetMapping("/doctor/getDoctorInfoById")
    public Result<HashMap<Object, Object>> getDoctorInfoById(@RequestParam(value = "doctor_id") long doctor_id) {
        HashMap<Object, Object> doctor = getDoctorInfoService.getDetailedDoctorInfoById(doctor_id);
        if (doctor == null) return Result.error("doctor not found");
        return Result.ok(doctor);
    }

    @GetMapping("/doctor/getDoctorInfo")
    public Result<List<Doctor>> getDoctorInfo(@RequestParam(value = "name", required = false) String name,
                                              @RequestParam(value = "gender", required = false) String gender,
                                              @RequestParam(value = "birthday", required = false) String birthday,
                                              @RequestParam(value = "department", required = false) String department,
                                              @RequestParam(value = "hospital_id", required = false) String hospital_id,
                                              @RequestParam Integer page,
                                              @RequestParam Integer size) {
        Page<HashMap<String, String>> pageInfo = PageHelper.startPage(page, size);
        List<HashMap<String, String>> list = getDoctorInfoService.getDoctorInfo(name, gender, birthday, department, hospital_id);
        if (list == null) return null;
        return Result.pagedOk(pageInfo, pageInfo.getTotal());
    }
}
