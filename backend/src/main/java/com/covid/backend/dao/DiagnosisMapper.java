package com.covid.backend.dao;

import com.covid.backend.pojo.Diagnosis;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiagnosisMapper {

    @Select("select * from diagnosis where diagnosis_id=#{diagnosis_id}")
    Diagnosis selectDiagnosisById(@Param("diagnosis_id") long diagnosis_id);

    @Select("select count(*) from diagnosis")
    Integer getNumber();

    @Select("select * from diagnosis where patient_id = cast(#{patient_id} as Integer) and cast(doctor_id as varchar) like #{doctor_id} and cast(time as varchar) like concat('%',#{time},'%') and temperature like concat('%',#{temperature},'%') and symptom like concat('%',#{symptom},'%') and nucleic_acid LIKE #{nucleic_acid}")
    List<Diagnosis> selectDiagnosis(Diagnosis diagnosis);

    @SelectKey(statement = "select nextval('diagnosis_diagnosis_id_seq') as diagnosis_id", keyProperty = "diagnosis_id", before = false, resultType = long.class)
    @Insert("insert into diagnosis(patient_id, doctor_id, time, symptom, temperature, nucleic_acid) values (cast(#{patient_id} as integer), cast(#{doctor_id} as integer), #{time}, #{symptom}, #{temperature}, #{nucleic_acid})")
    int insertDiagnosis(Diagnosis diagnosis);

    @Update("update diagnosis set patient_id=cast(#{patient_id} as integer), doctor_id=cast(#{doctor_id} as integer), time=#{time}, symptom=#{symptom}, temperature=#{temperature}, nucleic_acid=#{nucleic_acid} where diagnosis_id=#{diagnosis_id}")
    int updateDiagnosis(Diagnosis diagnosis);

    @Delete("delete from diagnosis where diagnosis_id = #{diagnosis_id}")
    int deleteDiagnosisById(@Param("diagnosis_id") long diagnosis_id);
}
