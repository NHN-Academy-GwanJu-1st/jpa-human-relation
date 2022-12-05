package com.nhnacademy.repository;

import com.nhnacademy.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk>, FamilyRelationshipRepositoryCustom {

    FamilyRelationship findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(Long familyResidentSerialNumber, Long baseSerialNumber);

    void deleteByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(Long familyResidentSerialNumber, Long baseSerialNumber);

    List<FamilyRelationship> findByPk_FamilyResidentSerialNumber(Long familyResidentSerialNumber);


}
