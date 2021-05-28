package com.covid.backend.controller.medicine;

import com.covid.backend.pojo.Medicine;
import com.covid.backend.service.medicine.GetMedicineInfoService;
import com.covid.backend.utils.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetMedicineInfo {

    @Autowired
    public GetMedicineInfoService getMedicineInfoService;

    @GetMapping("/medicine/getMedicineInfoById")
    public Result<Medicine> getMedicineInfoById(@RequestParam(value = "medicine_id") long medicine_id) {
        Medicine medicine = getMedicineInfoService.getMedicineById(medicine_id);
        if (medicine == null) return Result.error("medicine not found");
        return Result.ok(medicine);
    }

    @GetMapping("/medicine/getMedicineInfo")
    public Result<List<Medicine>> getMedicineInfo(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "manufacturer", required = false) String manufacturer,
                                                  @RequestParam(value = "introduction", required = false) String introduction,
                                                  @RequestParam(value = "type", required = false) String type,
                                                  @RequestParam Integer page,
                                                  @RequestParam Integer size) {
        Page<Medicine> resultPage = PageHelper.startPage(page, size);
        List<Medicine> list = getMedicineInfoService.getMedicineInfo(name, manufacturer, introduction, type);
        if (list == null) return null;
        return Result.pagedOk(resultPage);
    }
}
