package com.covid.backend.dao;

import com.covid.backend.pojo.Hospital;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HospitalMapper {

    @Select("select * from hospital where hospital_id=#{hospital_id}")
    Hospital selectHospitalById(@Param("hospital_id") long hospital_id);

    @Select("select * from hospital where hospital_name like concat('%',#{hospital_name},'%') and address like concat('%',#{address},'%')")
    List<Hospital> selectHospital(Hospital hospital);

    @SelectKey(statement = "select nextval('hospital_hospital_id_seq') as hospital_id", keyProperty = "hospital_id", before = false, resultType = long.class)
    @Insert("insert into hospital(hospital_name, address) values (#{hospital_name}, #{address})")
    int insertHospital(Hospital hospital);

    @Update("update hospital set hospital_name=#{hospital_name}, address=#{address} where hospital_id=#{hospital_id}")
    int updateHospital(Hospital hospital);

    @Delete("delete from hospital where hospital_id = #{hospital_id}")
    int deleteHospitalById(@Param("hospital_id") long hospital_id);

}
