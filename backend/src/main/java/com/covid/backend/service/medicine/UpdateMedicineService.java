package com.covid.backend.service.medicine;

import com.covid.backend.pojo.Medicine;
import com.covid.backend.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateMedicineService extends BaseService {
    @Autowired
    public GetMedicineInfoService getMedicineInfoService;

    //TODO check login

    public int updateMedicineInfo(long medicine_id,
                                  String name,
                                  String manufacturer,
                                  String introduction,
                                  String type) {
        Medicine medicine = getMedicineInfoService.getMedicineById(medicine_id);
        medicine.setMedicine_name(name);
        medicine.setManufacturer(manufacturer);
        medicine.setIntroduction(introduction);
        medicine.setType(type);
        return medicineMapper.updateMedicineInfo(medicine);
    }
}
