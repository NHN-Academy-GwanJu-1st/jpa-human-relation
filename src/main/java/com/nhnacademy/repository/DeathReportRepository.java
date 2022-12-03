package com.nhnacademy.repository;

import com.nhnacademy.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeathReportRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
}
