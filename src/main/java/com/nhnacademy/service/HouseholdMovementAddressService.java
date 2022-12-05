package com.nhnacademy.service;

import com.nhnacademy.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.entity.HouseholdMovementAddress;

public interface HouseholdMovementAddressService {

    HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressDTO householdMovementAddressDTO);
}
