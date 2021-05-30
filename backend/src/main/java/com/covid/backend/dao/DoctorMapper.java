package com.covid.backend.dao;

import com.covid.backend.pojo.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DoctorMapper {

    @Select("select * from doctor where doctor_id=#{doctor_id}")
    Doctor selectDoctorById(@Param("doctor_id") long doctor_id);

    // doctor's hospital
    @Select("select * from doctor NATURAL JOIN hospital where doctor_id=#{doctor_id}")
    HashMap<Object, Object> selectDoctorDetailById(@Param("doctor_id") long doctor_id);

    @Select("select * from doctor where doctor_name like #{doctor_name} and doctor_gender like concat('%',#{doctor_gender},'%') and doctor_birthday like concat('%',#{doctor_birthday},'%') and department like concat('%',#{department},'%') and cast(hospital_id as varchar) like #{hospital_id}")
    List<HashMap<String, String>> selectDetailedDoctors(@Param("doctor_name") String name,
                                                        @Param("doctor_gender") String gender,
                                                        @Param("doctor_birthday") String birthday,
                                                        @Param("department") String department,
                                                        @Param("hospital_id") String hospital_id);

    @SelectKey(statement = "select nextval('doctor_doctor_id_seq') as doctor_id", keyProperty = "doctor_id", before = false, resultType = long.class)
    @Insert("insert into doctor(doctor_name, doctor_gender, doctor_birthday, department, hospital_id) values (#{doctor_name}, #{doctor_gender}, #{doctor_birthday}, #{department}, cast(#{hospital_id} as integer))")
    int insertDoctor(Doctor doctor);

    @Update("update doctor set doctor_name=#{doctor_name}, doctor_gender=#{doctor_gender}, doctor_birthday=#{doctor_birthday}, department=#{department}, hospital_id=cast(#{hospital_id} as integer) where doctor_id=#{doctor_id}")
    int updateDoctor(Doctor doctor);

    @Delete("delete from doctor where doctor_id = #{doctor_id}")
    int deleteDoctorById(@Param("doctor_id") long doctor_id);
}
