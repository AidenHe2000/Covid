package com.covid.backend.dao;

import com.covid.backend.pojo.Prescription;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PrescriptionMapper {

    @Select("select * from prescription where prescription_id=#{prescription_id}")
    Prescription selectPrescriptionById(@Param("prescription_id") long prescription_id);

    @Select("select count(*) from prescription")
    Integer getNumber();

    @Select("select * from prescription natural join doctor natural join medicine where cast(patient_id as varchar)=#{patient_id}")
    List<HashMap<String, String>> selectDetailedPrescriptionByPatientId(@Param("patient_id") String patient_id);

    @Select("select * from prescription where cast(patient_id as varchar) like concat('%',#{patient_id},'%')and cast(medicine_id as varchar) like concat('%',#{medicine_id},'%')and dosage like concat('%',#{dosage},'%') and usage like concat('%',#{usage},'%')and cast(doctor_id as varchar) like concat('%',#{doctor_id},'%') and cast(prescription_date as varchar) like concat('%',#{prescription_date},'%')")
    List<Prescription> selectPrescription(@Param("patient_id") String patient_id,
                                          @Param("medicine_id") String medicine_id,
                                          @Param("dosage") String dosage,
                                          @Param("usage") String usage,
                                          @Param("doctor_id") String doctor_id,
                                          @Param("prescription_date") String prescription_date);

    @Select("select * FROM prescription WHERE cast(patient_id as varchar) = #{patient_id}")
    List<Prescription> selectPrescriptionByPatientId(@Param("patient_id") String patient_id);

    @SelectKey(statement = "select nextval('prescription_prescription_id_seq') as prescription_id", keyProperty = "prescription_id", before = false, resultType = long.class)
    @Insert("insert into prescription(patient_id, medicine_id, doctor_id,dosage, usage,prescription_date) values (cast(#{patient_id} as integer), cast(#{medicine_id} as integer), cast(#{doctor_id} as integer), #{dosage}, #{usage}, #{prescription_date})")
    int insertPrescription(Prescription prescription);

    @Update("update prescription set patient_id=cast(#{patient_id} as integer), medicine_id=cast(#{medicine_id} as integer), doctor_id=cast(#{doctor_id} as integer), dosage=#{dosage}, usage=#{usage}, prescription_date=#{prescription_date} where prescription_id=#{prescription_id}")
    int updatePrescription(Prescription prescription);

    @Delete("delete from prescription where prescription_id = #{prescription_id}")
    int deletePrescriptionById(@Param("prescription_id") long prescription_id);
}
