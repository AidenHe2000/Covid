package com.covid.backend.service.hospital;

import com.covid.backend.pojo.Hospital;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHospitalInfoService extends BaseService {

    public Hospital getHospitalInfoById(long hospital_id) {
        return hospitalMapper.selectHospitalById(hospital_id);
    }

    public List<Hospital> getHospital(Hospital hospital) {
        if (hospital.getHospital_name() == null) hospital.setHospital_name("%");
        if (hospital.getAddress() == null) hospital.setAddress("%");
        return hospitalMapper.selectHospital(hospital);
    }
}
