package com.nhnacademy.repository;

import com.nhnacademy.domain.FamilyRelationshipDTO;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface FamilyRelationshipRepositoryCustom {
    List<FamilyRelationshipDTO> getFamilyRelationNumberAndCode(Long serialNumber);
}
