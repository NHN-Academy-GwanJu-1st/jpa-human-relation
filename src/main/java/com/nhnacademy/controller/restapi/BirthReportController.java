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
@RequestMapping("/residents/{serialNumber}/birth")
public class BirthReportController {

    private final BirthReportService birthReportService;

    @PostMapping
    public BirthDeathReportResident registerBirthReport(@PathVariable(name = "serialNumber") Long serialNumber,
                                                        @RequestBody BirthReportDTO birthReportDTO) {
        return birthReportService.registerBirthReport(serialNumber, birthReportDTO);
    }

    @PutMapping("/{targetSerialNumber}")
    public BirthDeathReportResident modifyBirthReport(@PathVariable(name = "serialNumber") Long serialNumber,
                                                      @PathVariable(name = "targetSerialNumber") Long targetSerialNumber,
                                                      @RequestBody BirthReportDTO birthReportDTO) {
        return birthReportService.modifyBirthReport(serialNumber, targetSerialNumber, birthReportDTO);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public void deleteBirthReport(@PathVariable(name = "serialNumber") Long serialNumber,
                                  @PathVariable(name = "targetSerialNumber") Long targetSerialNumber) {
        birthReportService.deleteBirthReport(serialNumber, targetSerialNumber);
    }


}
