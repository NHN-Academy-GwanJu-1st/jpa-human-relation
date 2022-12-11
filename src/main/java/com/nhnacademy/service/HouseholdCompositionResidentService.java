package com.nhnacademy.service;

import com.nhnacademy.entity.HouseholdCompositionResident;

import java.util.List;

public interface HouseholdCompositionResidentService {
    List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber);
}
