package com.covid.backend.service.hospital;

import com.covid.backend.pojo.Hospital;
import com.covid.backend.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateHospitalService extends BaseService {

    @Autowired
    public GetHospitalInfoService getHospitalInfoService;

    //TODO check login

    public int updateHospital(Hospital hospital) {
        Hospital old = getHospitalInfoService.getHospitalInfoById(hospital.getHospital_id());
        old.setHospital_name(hospital.getHospital_name());
        old.setAddress(hospital.getAddress());
        return hospitalMapper.updateHospital(old);
    }
}
