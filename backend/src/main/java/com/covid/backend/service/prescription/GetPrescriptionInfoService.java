package com.covid.backend.service.prescription;

import com.covid.backend.pojo.Prescription;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GetPrescriptionInfoService extends BaseService {

    public Prescription getPrescriptionById(long prescription_id) {
        return prescriptionMapper.selectPrescriptionById(prescription_id);
    }

    public Integer getPrescriptionNumber() {
        return prescriptionMapper.getNumber();
    }

    public List<HashMap<String, String>> getDetailedPrescriptionByPatientId(String patient_id) {
        return prescriptionMapper.selectDetailedPrescriptionByPatientId(patient_id);
    }

    public List<Prescription> getPrescriptionInfo(String patient_id,
                                                  String medicine_id,
                                                  String dosage,
                                                  String usage,
                                                  String doctor_id,
                                                  String prescription_date) {
        if (patient_id == null) patient_id = "%";
        if (medicine_id == null) medicine_id = "%";
        if (dosage == null) dosage = "%";
        if (usage == null) usage = "%";
        if (doctor_id == null) doctor_id = "%";
        if (prescription_date == null) prescription_date = "%";
        return prescriptionMapper.selectPrescription(patient_id, medicine_id, dosage, usage, doctor_id, prescription_date);
    }

    public List<Prescription> getPrescriptionByPatientId(String patient_id) {
        return prescriptionMapper.selectPrescriptionByPatientId(patient_id);
    }
}
