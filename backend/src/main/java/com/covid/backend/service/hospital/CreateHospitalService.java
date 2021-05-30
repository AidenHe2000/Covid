package com.covid.backend.service.hospital;

import com.covid.backend.pojo.Hospital;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CreateHospitalService extends BaseService {

    //TODO login check

    public int createHospital(Hospital hospital) {
        return hospitalMapper.insertHospital(hospital);
    }
}
