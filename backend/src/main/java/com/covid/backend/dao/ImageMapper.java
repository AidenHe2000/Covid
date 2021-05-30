package com.covid.backend.dao;

import com.covid.backend.pojo.Image;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ImageMapper {

    @Select("select * from image where image_id=#{image_id}")
    Image selectImageById(@Param("image_id") long image_id);

    @Select("select * from image where cast(patient_id as varchar) like concat('%',#{patient_id},'%') and scanning_doctor_id like concat('%',#{scanning_doctor_id},'%') and image_picture like concat('%',#{image_picture},'%') and conclusion like concat('%',#{conclusion},'%') and cast(conclusion_doctor_id as varchar) like #{conclusion_doctor_id}")
    List<Image> selectImage(Image image);

    @SelectKey(statement = "select nextval('image_image_id_seq') as image_id", keyProperty = "image_id", before = false, resultType = long.class)
    @Insert("insert into image(patient_id, doctor_id, scanning_doctor_id, image_picture, conclusion, conclusion_doctor_id) values (cast(#{patient_id} as integer), cast(#{doctor_id} as integer), #{scanning_doctor_id}, #{image_picture}, #{conclusion}, cast(#{conclusion_doctor_id} as integer))")
    int insertImage(Image image);

    @Update("update image set patient_id=cast(#{patient_id} as integer), doctor_id=cast(#{doctor_id} as integer),scanning_doctor_id=#{scanning_doctor_id}, image_picture=#{image_picture}, conclusion=#{conclusion}, conclusion_doctor_id=cast(#{conclusion_doctor_id} as integer) where image_id=#{image_id}")
    int updateImage(Image image);

    @Delete("delete from image where image_id = #{image_id}")
    int deleteImage(@Param("image_id") long image_id);
}
