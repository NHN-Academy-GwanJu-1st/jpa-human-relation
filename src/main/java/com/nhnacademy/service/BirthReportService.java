package com.nhnacademy.service;

import com.nhnacademy.domain.BirthReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;

public interface BirthReportService {

    BirthDeathReportResident registerBirthReport(Long serialNumber, BirthReportDTO birthReportDTO);

    BirthDeathReportResident modifyBirthReport(Long serialNumber, Long targetSerialNumber, BirthReportDTO birthReportDTO);

    void deleteBirthReport(Long serialNumber, Long targetSerialNumber);
}
