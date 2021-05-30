package com.covid.backend.service.doctor;

import com.covid.backend.pojo.Doctor;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CreateDoctorService extends BaseService {

    //TODO login check

    public int createDoctor(String name,
                            String gender,
                            String birthday,
                            String department,
                            String hospital_id) {
        Doctor doctor = new Doctor();
        doctor.setDoctor_name(name);
        doctor.setDoctor_gender(gender);
        doctor.setDoctor_birthday(birthday);
        doctor.setDepartment(department);
        doctor.setHospital_id(hospital_id);
        return doctorMapper.insertDoctor(doctor);
    }
}
