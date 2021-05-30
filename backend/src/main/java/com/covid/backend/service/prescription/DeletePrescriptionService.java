package com.covid.backend.service.prescription;

import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DeletePrescriptionService extends BaseService {

    //TODO login check

    public int deletePrescriptionById(long prescription_id) {
        return prescriptionMapper.deletePrescriptionById(prescription_id);
    }
}
