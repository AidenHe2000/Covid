package com.covid.backend.controller.medicine;

import com.covid.backend.pojo.Medicine;
import com.covid.backend.service.medicine.GetMedicineInfoService;
import com.covid.backend.service.medicine.UpdateMedicineService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateMedicine {

    @Autowired
    public UpdateMedicineService updateMedicineService;
    @Autowired
    public GetMedicineInfoService getMedicineInfoService;

    @GetMapping("/medicine/updateMedicine")
    public Result updateMedicine(@RequestParam(value = "medicine_id") long medicine_id,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "manufacturer", required = false) String manufacturer,
                                 @RequestParam(value = "introduction", required = false) String introduction,
                                 @RequestParam(value = "type", required = false) String type) {
        //TODO login check
        Medicine medicine = getMedicineInfoService.getMedicineById(medicine_id);
        if (medicine == null) return Result.error("medicine not found");
        int affectedLine = updateMedicineService.updateMedicineInfo(medicine_id, name, manufacturer, introduction, type);
        return Result.ok(affectedLine);
    }
}
