package com.covid.backend.service.prescription;

import com.covid.backend.pojo.Prescription;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CreatePrescriptionService extends BaseService {

    //TODO login check

    public int createPrescription(String patient_id,
                                  String medicine_id,
                                  String doctor_id,
                                  String dosage,
                                  String usage,
                                  String prescription_date) {
        Prescription prescription = new Prescription();
        prescription.setPatient_id(patient_id);
        prescription.setMedicine_id(medicine_id);
        prescription.setDoctor_id(doctor_id);
        prescription.setDosage(dosage);
        prescription.setUsage(usage);
        prescription.setPrescription_date(prescription_date);
        return prescriptionMapper.insertPrescription(prescription);
    }
}
