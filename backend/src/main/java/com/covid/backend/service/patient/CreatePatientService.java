package com.covid.backend.service.patient;

import com.covid.backend.pojo.Patient;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientService extends BaseService {

    //TODO login check

    public int createPatient(String name,
                             String gender,
                             String birthday,
                             String onset_place,
                             String onset_date,
                             String confirm_date,
                             String status,
                             String doctor_id,
                             String hospital_id,
                             String is_doctor) {
        Patient patient = new Patient();
        patient.setPatient_name(name);
        patient.setPatient_gender(gender);
        patient.setPatient_birthday(birthday);
        patient.setOnset_place(onset_place);
        patient.setOnset_date(onset_date);
        patient.setConfirm_date(confirm_date);
        patient.setStatus(status);
        patient.setDoctor_id(doctor_id);
        patient.setHospital_id(hospital_id);
        patient.setIs_doctor(is_doctor);
        return patientMapper.insertPatient(patient);
    }
}
