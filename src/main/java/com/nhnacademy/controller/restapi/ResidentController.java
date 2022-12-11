package com.nhnacademy.controller.restapi;

import com.nhnacademy.domain.ResidentModifyDTO;
import com.nhnacademy.domain.ResidentRegisterDTO;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public Resident registerResident(@RequestBody ResidentRegisterDTO residentRegisterDTO) {

        System.out.println(residentRegisterDTO);
        return residentService.registerResident(residentRegisterDTO);
    }

    @PutMapping("/{serialNumber}")
    public Resident modifyResident(@PathVariable(name = "serialNumber") Long serialNumber,
                                   @RequestBody ResidentModifyDTO residentModifyDTO) {
        return residentService.modifyResident(serialNumber, residentModifyDTO);
    }


}

