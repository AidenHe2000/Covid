package com.covid.backend.service.patient;

import com.covid.backend.pojo.Patient;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GetPatientInfoService extends BaseService {


    public Patient getPatientInfoById(long patient_id) {
        return patientMapper.selectPatientById(patient_id);
    }

    public HashMap<String, String> getDetailedPatientById(long patient_id) {
        return patientMapper.selectDetailedPatientById(patient_id);
    }

    public List<HashMap<String, String>> getPatientInfo(String name,
                                                        String gender,
                                                        String birthday,
                                                        String onset_place,
                                                        String onset_date,
                                                        String confirm_date,
                                                        String status,
                                                        String doctor_id,
                                                        String hospital_id,
                                                        String is_doctor) {
        if (name == null) name = "%";
        if (gender == null) gender = "%";
        if (birthday == null) birthday = "%";
        if (onset_place == null) onset_place = "%";
        if (onset_date == null) onset_date = "%";
        if (confirm_date == null) confirm_date = "%";
        if (status == null) status = "%";
        if (doctor_id == null) doctor_id = "%";
        if (hospital_id == null) hospital_id = "%";
        if (is_doctor == null) is_doctor = "%";
        return patientMapper.selectMultipleDetailedPatient(name, gender, birthday, onset_place, onset_date, confirm_date, status, doctor_id, hospital_id, is_doctor);
    }
}
