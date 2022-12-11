package com.nhnacademy.service;

import com.nhnacademy.domain.HouseholdDTO;
import com.nhnacademy.entity.Household;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.exception.NotFoundResidentException;
import com.nhnacademy.repository.HouseholdRepository;
import com.nhnacademy.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final ResidentRepository residentRepository;
    private final HouseholdRepository householdRepository;

    @Override
    public Household registerHousehold(HouseholdDTO householdDTO) {

        Resident householdResident = residentRepository.findById(householdDTO.getHouseholdResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);

        Household household = new Household().builder()
                .householdResidentSerialNumber(householdResident)
                .householdCompositionDate(householdDTO.getHouseholdCompositionDate())
                .householdCompositionReasonCode(householdDTO.getHouseholdCompositionReasonCode())
                .currentHouseMovementAddress(householdDTO.getCurrentHouseMovementAddress())
                .householdCompositionResidents(null)
                .householdMovementAddresses(null)
                .build();

        return householdRepository.save(household);
    }

    @Override
    public void deleteHousehold(Long householdSerialNumber) {
        householdRepository.deleteById(householdSerialNumber);
    }

    @Override
    public Household findByResidentSerialNumber(Long residentSerialNumber) {
        return householdRepository.findByResidentSerialNumber(residentSerialNumber);
    }
}
