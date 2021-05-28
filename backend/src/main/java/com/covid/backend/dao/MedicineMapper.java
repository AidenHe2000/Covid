package com.covid.backend.dao;

import com.covid.backend.pojo.Medicine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicineMapper {

    @Select("select * from medicine where medicine_id=#{medicine_id}")
    Medicine selectMedicineById(@Param("medicine_id") long medicine_id);

    @Select("select * from medicine where medicine_name like concat('%',#{medicine_name},'%') and manufacturer like concat('%',#{manufacturer},'%') and introduction like concat('%',#{introduction},'%') and type like concat('%',#{type},'%')")
    List<Medicine> selectMedicine(@Param("medicine_name") String name,
                                  @Param("manufacturer") String manufacturer,
                                  @Param("introduction") String introduction,
                                  @Param("type") String type);

    @SelectKey(statement = "select nextval('medicine_medicine_id_seq') as medicine_id", keyProperty = "medicine_id", before = false, resultType = long.class)
    @Insert("insert into medicine(medicine_name, manufacturer, introduction, type) values (#{medicine_name}, #{manufacturer}, #{introduction}, #{type})")
    int insertMedicine(Medicine medicine);

    @Delete("delete from medicine where medicine_id = #{medicine_id}")
    int deleteMedicineById(@Param("medicine_id") long medicine_id);

    @Update("update medicine set medicine_name=#{medicine_name}, manufacturer=#{manufacturer}, introduction=#{introduction}, type=#{type} where medicine_id=#{medicine_id}")
    int updateMedicineInfo(Medicine medicine);
}
