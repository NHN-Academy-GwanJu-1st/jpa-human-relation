package com.nhnacademy.repository;

import com.nhnacademy.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface BirthReportRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {

    BirthDeathReportResident findByPk_ResidentSerialNumberAndReportResidentSerialNumber_ResidentSerialNumber(Long residentSerialNumber, Long reportResidentSerialNumber);

    @Transactional
    void deleteByPk_ResidentSerialNumberAndReportResidentSerialNumber_ResidentSerialNumber(Long residentSerialNumber, Long reportResidentSerialNumber);

}
