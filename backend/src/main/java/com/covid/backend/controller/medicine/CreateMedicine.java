package com.covid.backend.controller.medicine;

import com.covid.backend.service.medicine.CreateMedicineService;
import com.covid.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateMedicine {

    @Autowired
    public CreateMedicineService createMedicineService;

    @GetMapping("/medicine/createMedicine")
    public Result createMedicine(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "manufacturer", required = false) String manufacturer,
                                 @RequestParam(value = "introduction", required = false) String introduction,
                                 @RequestParam(value = "type", required = false) String type) {
        // TODO login check

        int affectedLine = createMedicineService.createMedicine(name, manufacturer, introduction, type);

        return Result.ok(affectedLine);
    }
}
