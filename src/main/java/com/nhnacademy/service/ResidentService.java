package com.nhnacademy.service;

import com.nhnacademy.domain.ResidentModifyDTO;
import com.nhnacademy.domain.ResidentRegisterDTO;
import com.nhnacademy.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResidentService {

    Resident registerResident(ResidentRegisterDTO residentRegisterDTO);

    Resident modifyResident(Long serialNumber, ResidentModifyDTO residentModifyDTO);

    Page<Resident> findAll(Pageable pageable);

    Resident findById(Long serialNumber);

}
