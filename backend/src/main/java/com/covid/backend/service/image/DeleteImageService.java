package com.covid.backend.service.image;

import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DeleteImageService extends BaseService {
    //TODO login check

    public int deleteImageById(long image_id) {
        return imageMapper.deleteImage(image_id);
    }
}
