package com.nhnacademy.service;

import com.nhnacademy.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.entity.Household;
import com.nhnacademy.entity.HouseholdMovementAddress;
import com.nhnacademy.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.repository.HouseholdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class HouseholdMovementAddressServiceImpl implements HouseholdMovementAddressService {

    private final HouseholdRepository householdRepository;
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;

    @Transactional
    @Override
    public HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressDTO householdMovementAddressDTO) {

        HouseholdMovementAddress lastMovementAddress = householdMovementAddressRepository.getLastMovementAddress(householdSerialNumber);
        lastMovementAddress.setLastAddressYn('N');

        householdMovementAddressRepository.save(lastMovementAddress);

        Household household = householdRepository.findById(householdSerialNumber).orElseThrow(NoSuchElementException::new);

        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress().builder()
                .pk(new HouseholdMovementAddress.Pk(householdSerialNumber, householdMovementAddressDTO.getHouseMovementReportDate()))
                .household(household)
                .houseMovementAddress(householdMovementAddressDTO.getHouseMovementAddress())
                .lastAddressYn('Y')
                .build();

        return householdMovementAddressRepository.save(householdMovementAddress);
    }

    @Override
    public List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber) {
        return householdMovementAddressRepository.getMovementAddressByResidentSerialNumber(residentSerialNumber);
    }
}
