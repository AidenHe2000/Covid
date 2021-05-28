package com.covid.backend.service.medicine;

import com.covid.backend.pojo.Medicine;
import com.covid.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMedicineInfoService extends BaseService {

    public Medicine getMedicineById(long medicine_id) {
        return medicineMapper.selectMedicineById(medicine_id);
    }

    public List<Medicine> getMedicineInfo(String name,
                                          String manufacturer,
                                          String introduction,
                                          String type) {
        if (name == null) name = "%";
        if (manufacturer == null) manufacturer = "%";
        if (introduction == null) introduction = "%";
        if (type == null) type = "%";

        return medicineMapper.selectMedicine(name, manufacturer, introduction, type);
    }
}
