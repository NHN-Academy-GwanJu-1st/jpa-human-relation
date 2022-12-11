package com.nhnacademy.service;

import com.nhnacademy.entity.HouseholdCompositionResident;
import com.nhnacademy.repository.HouseholdCompositionResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HouseholdCompositionResidentServiceImpl implements HouseholdCompositionResidentService {

    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;

    public HouseholdCompositionResidentServiceImpl(HouseholdCompositionResidentRepository householdCompositionResidentRepository) {
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
    }

    @Override
    public List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber) {
        return householdCompositionResidentRepository.getHouseholdCompositionByHouseholdResidentSerialNumber(residentSerialNumber);
    }
}
