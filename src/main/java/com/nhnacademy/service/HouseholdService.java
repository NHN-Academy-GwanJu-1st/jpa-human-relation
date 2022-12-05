package com.nhnacademy.service;

import com.nhnacademy.domain.HouseholdDTO;
import com.nhnacademy.entity.Household;

public interface HouseholdService {

    Household registerHousehold(HouseholdDTO householdDTO);

    void deleteHousehold(Long householdSerialNumber);

    Household findByResidentSerialNumber(Long residentSerialNumber);
}
