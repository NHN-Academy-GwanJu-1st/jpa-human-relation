package com.nhnacademy.controller.view;

import com.nhnacademy.domain.CertificateIssueDTO;
import com.nhnacademy.entity.Household;
import com.nhnacademy.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.service.CertificateIssueService;
import com.nhnacademy.service.HouseholdService;
import com.nhnacademy.service.ResidentService;
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
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;

    @GetMapping("/{serialNumber}")
    public String getResidentInfo(@PathVariable(name = "serialNumber") Long serialNumber,
                                  Model model) {

        CertificateIssueDTO certificateInfo = certificateIssueService.getCertificateInfoByResidentSerialNumber(serialNumber, "주민등록등본");
        Household household = householdService.findByResidentSerialNumber(serialNumber);
        model.addAttribute("certificateInfo", certificateInfo);
        model.addAttribute("household", household);
//        model.addAttribute("householdMovementAddress", householdMovementAddressRepository.findByPk_HouseholdSerialNumber(1L));
        model.addAttribute("householdMovementAddress", householdMovementAddressRepository.getMovementAddressByResidentSerialNumber(serialNumber));

        return "residentInfo";
    }
}
