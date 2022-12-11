package com.nhnacademy.service;

import com.nhnacademy.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.entity.HouseholdMovementAddress;

import java.util.List;

public interface HouseholdMovementAddressService {

    HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressDTO householdMovementAddressDTO);

    List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber);
}
