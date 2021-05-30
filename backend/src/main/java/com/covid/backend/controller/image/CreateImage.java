package com.covid.backend.controller.image;

import com.covid.backend.pojo.Image;
import com.covid.backend.service.image.CreateImageService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateImage {
    @Autowired
    public CreateImageService createImageService;

    @GetMapping("/image/createImage")
    public Result createImage(@RequestParam(value = "patient_id") String patient_id,
                              @RequestParam(value = "scanning_doctor_id", required = false) String scanning_doctor_id,
                              @RequestParam(value = "image_picture", required = false) String image_picture,
                              @RequestParam(value = "conclusion", required = false) String conclusion,
                              @RequestParam(value = "conclusion_doctor_id", required = false) String conclusion_doctor_id,
                              @RequestParam(value = "doctor_id") String doctor_id) {
        //TODO login check
        Image image = new Image();
        image.setPatient_id(patient_id);
        image.setScanning_doctor_id(scanning_doctor_id);
        image.setImage_picture(image_picture);
        image.setConclusion(conclusion);
        image.setConclusion_doctor_id(conclusion_doctor_id);
        image.setDoctor_id(doctor_id);

        int affectedLine = createImageService.createImage(image);
        return Result.ok(affectedLine);
    }
}
