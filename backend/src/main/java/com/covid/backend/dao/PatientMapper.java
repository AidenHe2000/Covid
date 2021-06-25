package com.covid.backend.dao;

import com.covid.backend.pojo.Patient;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PatientMapper {

    @Select("select * from patient where patient_id=#{patient_id}")
    Patient selectPatientById(@Param("patient_id") long patient_id);

    @Select("select * from patient NATURAL JOIN hospital NATURAL JOIN doctor where patient_id=#{patient_id}")
    HashMap<String, String> selectDetailedPatientById(@Param("patient_id") long patient_id);

    @Select("select * from patient NATURAL JOIN hospital NATURAL JOIN doctor where patient_gender like concat('%',#{patient_gender},'%') and cast(patient_birthday as varchar) like concat('%',#{patient_birthday},'%') and cast(onset_date as varchar) like concat('%',#{onset_date},'%') and cast(confirm_date as varchar) like concat('%',#{confirm_date},'%') and status like concat('%',#{status},'%') and cast(doctor_id as varchar) like #{doctor_id} and cast(hospital_id as varchar) like #{hospital_id} and cast(is_doctor as varchar) like #{is_doctor} and patient_name like concat('%',#{patient_name},'%') and onset_place like concat('%',#{onset_place},'%')")
    List<HashMap<String, String>> selectMultipleDetailedPatient(@Param("patient_name") String name,
                                                                @Param("patient_gender") String gender,
                                                                @Param("patient_birthday") String birthday,
                                                                @Param("onset_place") String onset_place,
                                                                @Param("onset_date") String onset_date,
                                                                @Param("confirm_date") String confirm_date,
                                                                @Param("status") String status,
                                                                @Param("doctor_id") String doctor_id,
                                                                @Param("hospital_id") String hospital_id,
                                                                @Param("is_doctor") String is_doctor);

    @SelectKey(statement = "select nextval('patient_patient_id_seq') as patient_id", keyProperty = "patient_id", before = false, resultType = long.class)
    @Insert("insert into patient(patient_name, patient_gender, patient_birthday, onset_place, onset_date, confirm_date, status, doctor_id, hospital_id, is_doctor) values (#{patient_name}, #{patient_gender}, #{patient_birthday}, #{onset_place}, #{onset_date}, #{confirm_date}, #{status}, cast(#{doctor_id} as integer), cast(#{hospital_id} as integer), #{is_doctor})")
    int insertPatient(Patient patient);

    @Update("update patient set patient_name=#{patient_name}, patient_gender=#{patient_gender}, patient_birthday=cast(#{patient_birthday} as timestamp), onset_place=#{onset_place}, onset_date=cast(#{onset_date}as timestamp), confirm_date=cast(#{confirm_date}as timestamp), status=#{status}, doctor_id=cast(#{doctor_id} as integer), hospital_id=cast(#{hospital_id} as integer), is_doctor=cast(#{is_doctor} as integer) where patient_id=#{patient_id}")
    int updatePatient(Patient patient);

    @Delete("delete from patient where patient_id = #{patient_id}")
    int deletePatientById(@Param("patient_id") long patient_id);
}
