package com.nhnacademy.controller.restapi;

import com.nhnacademy.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.entity.HouseholdMovementAddress;
import com.nhnacademy.service.HouseholdMovementAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/household/{householdSerialNumber}/movement")
public class HouseholdMovementAddressController {

    private final HouseholdMovementAddressService householdMovementAddressService;

    @PostMapping
    public HouseholdMovementAddress registerHouseholdMovementAddress(@PathVariable(name = "householdSerialNumber") Long householdSerialNumber,
                                                                     @RequestBody HouseholdMovementAddressDTO householdMovementAddressDTO) {
        return householdMovementAddressService.registerHouseholdMovementAddress(householdSerialNumber, householdMovementAddressDTO);
    }
}
