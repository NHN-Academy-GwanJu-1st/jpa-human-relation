package com.nhnacademy.repository;

import com.nhnacademy.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthReportRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {

}