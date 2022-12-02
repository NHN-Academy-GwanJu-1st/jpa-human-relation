package com.nhnacademy.service;

import com.nhnacademy.domain.FamilyRelationshipDTO;
import com.nhnacademy.domain.ResidentModifyDTO;
import com.nhnacademy.domain.ResidentRegisterDTO;
import com.nhnacademy.entity.FamilyRelationship;
import com.nhnacademy.entity.Resident;

public interface ResidentService {

    Resident registerResident(ResidentRegisterDTO residentRegisterDTO);

    Resident modifyResident(Long serialNumber, ResidentModifyDTO residentModifyDTO);


}
