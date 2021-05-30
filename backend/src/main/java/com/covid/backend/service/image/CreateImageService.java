package com.covid.backend.service.image;

import com.covid.backend.pojo.Image;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CreateImageService extends BaseService {
    //TODO login check

    public int createImage(Image image) {
        return imageMapper.insertImage(image);
    }
}
