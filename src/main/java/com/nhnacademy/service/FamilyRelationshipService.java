package com.nhnacademy.service;

import com.nhnacademy.domain.FamilyRelationshipDTO;
import com.nhnacademy.entity.FamilyRelationship;

public interface FamilyRelationshipService {

    FamilyRelationship registerFamilyRelationship(Long serialNumber, FamilyRelationshipDTO familyRelationshipDTO);

    FamilyRelationship modifyFamilyRelationship(Long familySerialNumber, Long serialNumber, FamilyRelationshipDTO familyRelationshipDTO);

    void deleteFamilyRelationship(Long familySerialNumber, Long serialNumber);
}
