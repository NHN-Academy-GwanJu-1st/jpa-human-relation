package com.nhnacademy.service;

import com.nhnacademy.domain.BirthReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;

public interface BirthReportService {

    BirthDeathReportResident registerBirthReport(BirthReportDTO birthReportDTO);

    BirthDeathReportResident modifyBirthReport(Long targetSerialNumber, BirthReportDTO birthReportDTO);

    void deleteBirthReport(Long targetSerialNumber);
}
