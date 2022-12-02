package com.nhnacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "household")
public class Household {

    @Id
    @Column(name = "household_serial_number")
    private Long householdSerialNumber;

    @JoinColumn(name = "household_resident_serial_number")
    private Long householdResidentSerialNumber;

    @Column(name = "household_composition_date")
    private LocalDateTime householdCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

    @OneToMany(mappedBy = "household")
    private List<HouseholdCompositionResident> householdCompositionResidents;

    @OneToMany(mappedBy = "householdSerialNumber")
    private List<HouseholdMovementAddress> householdMovementAddresses;
}
