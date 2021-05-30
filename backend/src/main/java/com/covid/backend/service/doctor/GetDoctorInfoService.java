package com.covid.backend.service.doctor;

import com.covid.backend.pojo.Doctor;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GetDoctorInfoService extends BaseService {

    public Doctor getDoctorInfoById(long doctor_id) {
        return doctorMapper.selectDoctorById(doctor_id);
    }

    public HashMap<Object, Object> getDetailedDoctorInfoById(long doctor_id) {
        return doctorMapper.selectDoctorDetailById(doctor_id);
    }

    public List<HashMap<String, String>> getDoctorInfo(String name,
                                                       String gender,
                                                       String birthday,
                                                       String department,
                                                       String hospital_id) {
        if (name == null) name = "%";
        if (gender == null) gender = "%";
        if (birthday == null) birthday = "%";
        if (department == null) department = "%";
        if (hospital_id == null) hospital_id = "%";

        return doctorMapper.selectDetailedDoctors(name, gender, birthday, department, hospital_id);
    }
}
