package com.nhnacademy.controller.view;

import com.nhnacademy.domain.CertificateIssueDTO;
import com.nhnacademy.entity.Household;
import com.nhnacademy.entity.HouseholdMovementAddress;
import com.nhnacademy.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/info")
public class ResidentInfoController {

    private final ResidentService residentService;
    private final HouseholdService householdService;
    private final CertificateIssueService certificateIssueService;

    private final HouseholdMovementAddressService householdMovementAddressService;

    private final HouseholdCompositionResidentService householdCompositionResidentService;
    @GetMapping("/{serialNumber}")
    public String getResidentInfo(@PathVariable(name = "serialNumber") Long serialNumber,
                                  Model model) {

        CertificateIssueDTO certificateInfo = certificateIssueService.getCertificateInfoByResidentSerialNumber(serialNumber, "주민등록등본");
        Household household = householdService.findByResidentSerialNumber(serialNumber);
        model.addAttribute("certificateInfo", certificateInfo);
        model.addAttribute("household", household);
        model.addAttribute("householdMovementAddressList", householdMovementAddressService.getMovementAddressByResidentSerialNumber(serialNumber));
        model.addAttribute("householdCompositionList", householdCompositionResidentService.getHouseholdCompositionByHouseholdResidentSerialNumber(serialNumber));
//        model.addAttribute("householdMovementAddress", householdService.getMovementAddressByResidentSerialNumber(serialNumber));
//        model.addAttribute("householdMovementAddress", householdMovementAddressRepository.findByPk_HouseholdSerialNumber(1L));
//        model.addAttribute("householdMovementAddress", householdMovementAddressRepository.getMovementAddressByResidentSerialNumber(serialNumber));

        return "residentInfo";
    }
}
