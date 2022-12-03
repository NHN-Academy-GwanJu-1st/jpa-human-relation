package com.nhnacademy.controller.restapi;

import com.nhnacademy.domain.BirthReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;
import com.nhnacademy.service.BirthReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/residents/birth")
public class BirthReportController {

    private final BirthReportService birthReportService;

    @PostMapping
    public BirthDeathReportResident registerBirthReport(@RequestBody BirthReportDTO birthReportDTO) {
        return birthReportService.registerBirthReport(birthReportDTO);
    }

    @PutMapping("/{targetSerialNumber}")
    public BirthDeathReportResident modifyBirthReport(@PathVariable(name = "targetSerialNumber") Long targetSerialNumber,
                                                      @RequestBody BirthReportDTO birthReportDTO) {
        return birthReportService.modifyBirthReport(targetSerialNumber, birthReportDTO);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public void deleteBirthReport(@PathVariable(name = "targetSerialNumber") Long targetSerialNumber) {
        birthReportService.deleteBirthReport(targetSerialNumber);
    }


}
