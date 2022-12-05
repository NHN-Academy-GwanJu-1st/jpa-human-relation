package com.nhnacademy.repository;

import com.nhnacademy.entity.HouseholdMovementAddress;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface HouseholdMovementAddressRepositoryCustom {

    HouseholdMovementAddress getLastMovementAddress(Long householdSerialNumber);

    List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber);
}
