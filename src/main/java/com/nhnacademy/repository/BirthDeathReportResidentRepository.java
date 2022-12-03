package com.nhnacademy.repository;

import com.nhnacademy.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {

    BirthDeathReportResident findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(Long residentSerialNumber, String birthDeathTypeCode);

    @Transactional
    void deleteByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(Long residentSerialNumber, String birthDeathTypeCode);

}
