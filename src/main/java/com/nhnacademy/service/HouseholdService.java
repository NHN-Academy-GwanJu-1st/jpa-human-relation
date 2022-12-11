package com.nhnacademy.service;

import com.nhnacademy.domain.HouseholdDTO;
import com.nhnacademy.entity.Household;

import java.util.List;

public interface HouseholdService {

    Household registerHousehold(HouseholdDTO householdDTO);

    void deleteHousehold(Long householdSerialNumber);

    Household findByResidentSerialNumber(Long residentSerialNumber);
}
