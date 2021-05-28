package com.covid.backend.service.medicine;

import com.covid.backend.pojo.Medicine;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CreateMedicineService extends BaseService {
    // TODO login check

    public int createMedicine(String name,
                               String manufacturer,
                               String introduction,
                               String type) {
        Medicine medicine = new Medicine();
        medicine.setMedicine_name(name);
        medicine.setManufacturer(manufacturer);
        medicine.setIntroduction(introduction);
        medicine.setType(type);
        return medicineMapper.insertMedicine(medicine);
    }
}
