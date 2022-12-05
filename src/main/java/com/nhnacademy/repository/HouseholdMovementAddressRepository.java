package com.nhnacademy.repository;

import com.nhnacademy.entity.CertificateIssue;
import com.nhnacademy.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk>, HouseholdMovementAddressRepositoryCustom {

    List<HouseholdMovementAddress> findByPk_HouseholdSerialNumber(Long householdSerialNumber);
}
