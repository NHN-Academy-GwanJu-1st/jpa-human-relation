package com.nhnacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {

    @EmbeddedId
    private Pk pk;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @JoinColumn(name = "report_resident_serial_number")
    private Long reportResidentSerialNumber;

    @Column(name = "birth_death_report_date")
    private LocalDateTime birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "resident_serial_number")
        private Long residentSerialNumber;

        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode;
    }

}
