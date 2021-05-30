package com.covid.backend.controller.image;

import com.covid.backend.pojo.Image;
import com.covid.backend.service.image.GetImageInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetImageInfo {
    @Autowired
    public GetImageInfoService getImageInfoService;

    @GetMapping("/image/getImageInfoById")
    public Result<Image> getImageInfoById(@RequestParam(value = "image_id") long image_id) {
        Image image = getImageInfoService.getImageInfoById(image_id);
        if (image == null) return Result.error("image not found");
        return Result.ok(image);
    }

    @GetMapping("/image/getImageInfo")
    public Result<List<Image>> getImageInfo(@RequestParam(value = "patient_id", required = false) String patient_id,
                                            @RequestParam(value = "scanning_doctor_id", required = false) String scanning_doctor_id,
                                            @RequestParam(value = "image_picture", required = false) String image_picture,
                                            @RequestParam(value = "conclusion", required = false) String conclusion,
                                            @RequestParam(value = "conclusion_doctor_id", required = false) String conclusion_doctor_id) {
        Image image = new Image();
        image.setPatient_id(patient_id);
        image.setScanning_doctor_id(scanning_doctor_id);
        image.setImage_picture(image_picture);
        image.setConclusion(conclusion);
        image.setConclusion_doctor_id(conclusion_doctor_id);
        List<Image> list = getImageInfoService.getImageInfo(image);
        if (list == null) return null;
        return Result.ok(list);
    }
}
