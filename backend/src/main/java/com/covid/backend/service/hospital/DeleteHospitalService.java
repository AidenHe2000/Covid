package com.covid.backend.service.hospital;

import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DeleteHospitalService extends BaseService {

    //TODO login check

    public int deleteHospitalById(long hospital_id) {
        return hospitalMapper.deleteHospitalById(hospital_id);
    }
}
