package com.covid.backend.controller.image;

import com.covid.backend.pojo.Image;
import com.covid.backend.service.image.DeleteImageService;
import com.covid.backend.service.image.GetImageInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteImage {
    @Autowired
    public DeleteImageService deleteImageService;
    @Autowired
    public GetImageInfoService getImageInfoService;

    @GetMapping("/image/deleteImageById")
    public Result deleteImageById(@RequestParam(value = "image_id") long image_id) {
        //TODO login check
        Image image = getImageInfoService.getImageInfoById(image_id);
        if (image == null) return Result.error("image not found");
        int affectedLine = deleteImageService.deleteImageById(image_id);
        return Result.ok(affectedLine);
    }
}
