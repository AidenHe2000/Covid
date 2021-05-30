package com.covid.backend.controller.image;

import com.covid.backend.pojo.Image;
import com.covid.backend.service.image.GetImageInfoService;
import com.covid.backend.service.image.UpdateImageService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateImage {

    @Autowired
    public UpdateImageService updateImageService;
    @Autowired
    public GetImageInfoService getImageInfoService;

    @GetMapping("/image/updateImage")
    public Result updateImage(@RequestParam(value = "image_id") long image_id,
                              @RequestParam(value = "patient_id") String patient_id,
                              @RequestParam(value = "scanning_doctor_id", required = false) String scanning_doctor_id,
                              @RequestParam(value = "image_picture", required = false) String image_picture,
                              @RequestParam(value = "conclusion", required = false) String conclusion,
                              @RequestParam(value = "conclusion_doctor_id", required = false) String conclusion_doctor_id,
                              @RequestParam(value = "doctor_id") String doctor_id) {
        //TODO login check

        Image image = getImageInfoService.getImageInfoById(image_id);
        if (image == null) return Result.error("image not found");

        image.setPatient_id(patient_id);
        image.setScanning_doctor_id(scanning_doctor_id);
        image.setImage_picture(image_picture);
        image.setConclusion(conclusion);
        image.setConclusion_doctor_id(conclusion_doctor_id);
        image.setDoctor_id(doctor_id);

        int affectedLine = updateImageService.updateImage(image);
        return Result.ok(affectedLine);
    }
}
