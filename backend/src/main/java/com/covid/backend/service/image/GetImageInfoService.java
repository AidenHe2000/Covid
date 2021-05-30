package com.covid.backend.service.image;

import com.covid.backend.pojo.Image;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetImageInfoService extends BaseService {

    public Image getImageInfoById(long image_id) {
        return imageMapper.selectImageById(image_id);
    }

    public List<Image> getImageInfo(Image image) {
        if (image.getPatient_id() == null) image.setPatient_id("%");
        if (image.getScanning_doctor_id() == null) image.setScanning_doctor_id("%");
        if (image.getImage_picture() == null) image.setImage_picture("%");
        if (image.getConclusion() == null) image.setConclusion("%");
        if (image.getConclusion_doctor_id() == null) image.setConclusion_doctor_id("%");
        if (image.getDoctor_id() == null) image.setDoctor_id("%");

        return imageMapper.selectImage(image);
    }
}
