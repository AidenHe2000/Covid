package com.covid.backend.service.doctor;

import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DeleteDoctorService extends BaseService {

    //TODO login check

    public int deleteDoctorById(long doctor_id) {
        return doctorMapper.deleteDoctorById(doctor_id);
    }
}
