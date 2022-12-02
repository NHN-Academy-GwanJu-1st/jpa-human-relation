package com.nhnacademy.service;

import com.nhnacademy.domain.BirthReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;

public interface BirthReportService {

    BirthDeathReportResident registerBirthReport(Long serialNumber, BirthReportDTO birthReportDTO);
}
