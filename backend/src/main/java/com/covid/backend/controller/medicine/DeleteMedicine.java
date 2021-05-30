package com.covid.backend.controller.medicine;

import com.covid.backend.pojo.Medicine;
import com.covid.backend.service.medicine.DeleteMedicineService;
import com.covid.backend.service.medicine.GetMedicineInfoService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteMedicine {

    @Autowired
    public DeleteMedicineService deleteMedicineService;
    @Autowired
    public GetMedicineInfoService getMedicineInfoService;

    @GetMapping("/medicine/deleteMedicineById")
    public Result deleteMedicineById(@RequestParam(value = "medicine_id") long medicine_id) {
        //TODO login check
        Medicine medicine = getMedicineInfoService.getMedicineById(medicine_id);
        if (medicine == null) return Result.error("medicine not found");
        int affectedLine = deleteMedicineService.deleteMedicineById(medicine_id);
        return Result.ok(affectedLine);
    }
}
