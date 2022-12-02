package com.nhnacademy.service;

import com.nhnacademy.domain.FamilyRelationshipDTO;
import com.nhnacademy.entity.FamilyRelationship;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.exception.NotFoundResidentException;
import com.nhnacademy.repository.FamilyRelationshipRepository;
import com.nhnacademy.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {

    private final ResidentRepository residentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;

    @Override
    public FamilyRelationship registerFamilyRelationship(Long serialNumber, FamilyRelationshipDTO familyRelationshipDTO) {

        Resident resident = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);

        FamilyRelationship familyRelationship = new FamilyRelationship().builder()
                .pk(new FamilyRelationship.Pk(familyRelationshipDTO.getFamilySerialNumber(), serialNumber))
                .resident(resident)
                .familyRelationshipCode(familyRelationshipDTO.getFamilyRelationshipCode())
                .build();


        return familyRelationshipRepository.save(familyRelationship);
    }

    @Override
    public FamilyRelationship modifyFamilyRelationship(Long familySerialNumber, Long serialNumber, FamilyRelationshipDTO familyRelationshipDTO) {

        FamilyRelationship familyRelationship = familyRelationshipRepository
                .findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(familySerialNumber, serialNumber);

        if (Objects.isNull(familyRelationship)) {
            throw new NotFoundResidentException();
        }

        log.info("FamilyRelationshipDTO {}", familyRelationshipDTO);


        familyRelationship.setFamilyRelationshipCode(familyRelationshipDTO.getFamilyRelationshipCode());


        return familyRelationshipRepository.save(familyRelationship);
    }

    @Override
    public void deleteFamilyRelationship(Long familySerialNumber, Long serialNumber) {

        FamilyRelationship familyRelationship = familyRelationshipRepository
                .findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(familySerialNumber, serialNumber);

        if (Objects.isNull(familyRelationship)) {
            throw new NotFoundResidentException();
        }

        familyRelationshipRepository
                .deleteByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(familySerialNumber, serialNumber);
    }
}
