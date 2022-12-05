package com.nhnacademy.service;

import com.nhnacademy.domain.ResidentModifyDTO;
import com.nhnacademy.domain.ResidentRegisterDTO;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.exception.NotFoundResidentException;
import com.nhnacademy.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;

    @Override
    public Resident registerResident(ResidentRegisterDTO residentRegisterDTO) {

        Resident resident = new Resident().builder()
                .name(residentRegisterDTO.getName())
                .residentRegistrationNumber(residentRegisterDTO.getResidentRegistrationNumber())
                .genderCode(residentRegisterDTO.getGenderCode())
                .birthDate(residentRegisterDTO.getBirthDate())
                .birthPlaceCode(residentRegisterDTO.getBirthPlaceCode())
                .registrationBaseAddress(residentRegisterDTO.getRegistrationBaseAddress())
                .deathDate(residentRegisterDTO.getDeathDate())
                .deathPlaceCode(residentRegisterDTO.getDeathPlaceCode())
                .deathPlaceAddress(residentRegisterDTO.getDeathPlaceAddress())
                .build();

        return residentRepository.save(resident);
    }

    @Override
    public Resident modifyResident(Long serialNumber, ResidentModifyDTO residentModifyDTO) {

        Resident resident = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);

        resident.modifyResidentInfo(
                residentModifyDTO.getName(),
                residentModifyDTO.getRegistrationBaseAddress(),
                residentModifyDTO.getDeathDate(),
                residentModifyDTO.getDeathPlaceCode(),
                residentModifyDTO.getDeathPlaceAddress()
        );

        return residentRepository.save(resident);
    }

    @Override
    public Page<Resident> findAll(Pageable pageable) {
        return residentRepository.findAll(pageable);
    }

    @Override
    public Resident findById(Long serialNumber) {
        return residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);
    }
}
