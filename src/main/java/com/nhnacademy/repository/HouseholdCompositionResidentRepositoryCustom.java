package com.nhnacademy.repository;

import com.nhnacademy.entity.HouseholdCompositionResident;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface HouseholdCompositionResidentRepositoryCustom {

    List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber);
}
