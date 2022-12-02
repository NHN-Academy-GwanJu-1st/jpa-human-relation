package com.nhnacademy.repository;

import com.nhnacademy.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

    FamilyRelationship findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(Long familyResidentSerialNumber, Long baseSerialNumber);

//    @Transactional
    void deleteByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(Long familyResidentSerialNumber, Long baseSerialNumber);
}
