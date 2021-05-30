package com.covid.backend.service.prescription;

import com.covid.backend.pojo.Prescription;
import com.covid.backend.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePrescriptionService extends BaseService {

    @Autowired
    public GetPrescriptionInfoService getPrescriptionInfoService;

    //TODO login check

    public int updatePrescription(long prescription_id,
                                  String patient_id,
                                  String medicine_id,
                                  String dosage,
                                  String usage,
                                  String doctor_id,
                                  String prescription_date) {
        Prescription prescription = getPrescriptionInfoService.getPrescriptionById(prescription_id);
        prescription.setPatient_id(patient_id);
        prescription.setMedicine_id(medicine_id);
        prescription.setDosage(dosage);
        prescription.setUsage(usage);
        prescription.setDoctor_id(doctor_id);
        prescription.setPrescription_date(prescription_date);
        return prescriptionMapper.updatePrescription(prescription);
    }
}
