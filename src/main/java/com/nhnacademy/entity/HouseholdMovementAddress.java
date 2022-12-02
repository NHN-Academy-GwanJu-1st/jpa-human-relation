package com.nhnacademy.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {

    @EmbeddedId
    private Pk pk;

    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household householdSerialNumber;

//    @Id
//    @Column(name = "house_movement_report_date")
//    private LocalDateTime houseMovementReportDate;

    @Column(name = "house_movement_address")
    private String houseMovementAddress;

    @Column(name = "last_address_yn")
    private char lastAddressYn; /* default 'Y' */

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private Long householdSerialNumber;

        @Column(name = "house_movement_report_date")
        private LocalDateTime houseMovementReportDate;
    }

}
