package com.covid.backend.service.medicine;

import com.covid.backend.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMedicineService extends BaseService {

    @Autowired
    public GetMedicineInfoService getMedicineInfoService;

    //TODO login check

    public int deleteMedicineById(long medicine_id) {
        return medicineMapper.deleteMedicineById(medicine_id);
    }

}
