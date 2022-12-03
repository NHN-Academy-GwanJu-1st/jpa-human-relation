package com.nhnacademy.controller.restapi;

import com.nhnacademy.domain.BirthReportDTO;
import com.nhnacademy.domain.DeathReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;
import com.nhnacademy.service.DeathReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/residents/death")
public class DeathReportController {

    private final DeathReportService deathReportService;

    @PostMapping
    public BirthDeathReportResident registerDeathReport(@RequestBody DeathReportDTO deathReportDTO) {
        return deathReportService.registerDeathReport(deathReportDTO);
    }

    @PutMapping("/{targetSerialNumber}")
    public BirthDeathReportResident modifyBirthReport(@PathVariable(name = "targetSerialNumber") Long targetSerialNumber,
                                                      @RequestBody DeathReportDTO deathReportDTO) {
        return deathReportService.modifyDeathReport(targetSerialNumber, deathReportDTO);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public void deleteBirthReport(@PathVariable(name = "targetSerialNumber") Long targetSerialNumber) {
        deathReportService.deleteDeathReport(targetSerialNumber);
    }
}
