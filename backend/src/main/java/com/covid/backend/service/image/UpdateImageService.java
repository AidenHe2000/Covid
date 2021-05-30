package com.covid.backend.service.image;

import com.covid.backend.pojo.Image;
import com.covid.backend.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateImageService extends BaseService {
    @Autowired
    public GetImageInfoService getImageInfoService;

    //TODO login check

    public int updateImage(Image image) {
        Image old = getImageInfoService.getImageInfoById(image.getImage_id());

        old.setDoctor_id(image.getDoctor_id());
        old.setPatient_id(image.getPatient_id());
        old.setScanning_doctor_id(image.getScanning_doctor_id());
        old.setImage_picture(image.getImage_picture());
        old.setConclusion(image.getConclusion());
        old.setConclusion_doctor_id(image.getConclusion_doctor_id());

        return imageMapper.updateImage(old);
    }
}
