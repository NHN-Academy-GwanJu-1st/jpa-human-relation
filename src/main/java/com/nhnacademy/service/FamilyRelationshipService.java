package com.nhnacademy.service;

import com.nhnacademy.domain.FamilyRelationshipDTO;
import com.nhnacademy.domain.report.FamilyRelationshipReportDTO;
import com.nhnacademy.entity.FamilyRelationship;

import java.util.List;

public interface FamilyRelationshipService {

    FamilyRelationship registerFamilyRelationship(Long serialNumber, FamilyRelationshipDTO familyRelationshipRequest);

    FamilyRelationship modifyFamilyRelationship(Long familySerialNumber, Long serialNumber, FamilyRelationshipDTO familyRelationshipRequest);

    void deleteFamilyRelationship(Long familySerialNumber, Long serialNumber);

    List<FamilyRelationship> findByFamilySerialNumber(Long serialNumber);

    List<FamilyRelationshipReportDTO> getFamilyRelationNumberAndCode(Long serialNumber);

}
