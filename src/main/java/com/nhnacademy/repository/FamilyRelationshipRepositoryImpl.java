package com.nhnacademy.repository;

import com.nhnacademy.domain.FamilyRelationshipDTO;
import com.nhnacademy.entity.FamilyRelationship;
import com.nhnacademy.entity.QFamilyRelationship;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipRepositoryCustom {

    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<FamilyRelationshipDTO> getFamilyRelationNumberAndCode(Long serialNumber) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        return from(familyRelationship)
                .select(Projections.constructor(FamilyRelationshipDTO.class,
                        familyRelationship.pk.baseResidentSerialNumber,
                        familyRelationship.familyRelationshipCode))
                .where(familyRelationship.pk.familyResidentSerialNumber.eq(serialNumber))
                .fetch();
    }
}
