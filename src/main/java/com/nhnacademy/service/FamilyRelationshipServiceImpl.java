package com.nhnacademy.service;

import com.nhnacademy.domain.FamilyRelationshipDTO;
import com.nhnacademy.domain.report.FamilyRelationshipReportDTO;
import com.nhnacademy.entity.FamilyRelationship;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.exception.NotFoundResidentException;
import com.nhnacademy.repository.FamilyRelationshipRepository;
import com.nhnacademy.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {

    private final ResidentRepository residentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;

    @Override
    public FamilyRelationship registerFamilyRelationship(Long serialNumber, FamilyRelationshipDTO familyRelationshipRequest) {

        Resident resident = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);

        FamilyRelationship familyRelationship = new FamilyRelationship().builder()
                .pk(new FamilyRelationship.Pk(serialNumber, familyRelationshipRequest.getFamilySerialNumber()))
                .resident(resident)
                .familyRelationshipCode(familyRelationshipRequest.getFamilyRelationshipCode())
                .build();


        return familyRelationshipRepository.save(familyRelationship);
    }

    @Override
    public FamilyRelationship modifyFamilyRelationship(Long familySerialNumber, Long serialNumber, FamilyRelationshipDTO familyRelationshipRequest) {

        FamilyRelationship familyRelationship = familyRelationshipRepository
                .findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(familySerialNumber, serialNumber);

        if (Objects.isNull(familyRelationship)) {
            throw new NotFoundResidentException();
        }

        familyRelationship.setFamilyRelationshipCode(familyRelationshipRequest.getFamilyRelationshipCode());

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


    @Override
    public List<FamilyRelationship> findByFamilySerialNumber(Long serialNumber) {
        return null;
    }

    @Override
    public List<FamilyRelationshipReportDTO> getFamilyRelationNumberAndCode(Long serialNumber) {
        List<FamilyRelationshipDTO> familyRelationshipDTOList = familyRelationshipRepository.getFamilyRelationNumberAndCode(serialNumber);
        List<FamilyRelationshipReportDTO> result = new ArrayList<>();

        familyRelationshipDTOList.stream().forEach(familyRelationshipDTO -> {
            result.add(
                    new FamilyRelationshipReportDTO(
                            familyRelationshipDTO.getFamilyRelationshipCode(),
                            residentRepository.findById(familyRelationshipDTO.getFamilySerialNumber()).get()
                    )
            );
        });

        return result;
    }

}
