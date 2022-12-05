package com.nhnacademy.service;

import com.nhnacademy.domain.DeathReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;

public interface DeathReportService {

    BirthDeathReportResident registerDeathReport(DeathReportDTO deathReportDTO);

    BirthDeathReportResident modifyDeathReport(Long targetSerialNumber, DeathReportDTO deathReportDTO);

    void deleteDeathReport(Long targetSerialNumber);

}
