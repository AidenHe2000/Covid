package com.covid.backend.service.doctor;

import com.covid.backend.pojo.Doctor;
import com.covid.backend.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDoctorService extends BaseService {

    @Autowired
    public GetDoctorInfoService getDoctorInfoService;

    //TODO login check

    public int updateDoctor(long doctor_id,
                            String name,
                            String gender,
                            String birthday,
                            String department,
                            String hospital_id) {
        Doctor doctor = getDoctorInfoService.getDoctorInfoById(doctor_id);
        doctor.setDoctor_name(name);
        doctor.setDoctor_gender(gender);
        doctor.setDoctor_birthday(birthday);
        doctor.setDepartment(department);
        doctor.setHospital_id(hospital_id);
        return doctorMapper.updateDoctor(doctor);
    }
}
