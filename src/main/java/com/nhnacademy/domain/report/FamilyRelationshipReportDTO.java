package com.nhnacademy.domain.report;

import com.nhnacademy.entity.Resident;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRelationshipReportDTO {
    String familyRelationshipCode;
    Resident familyResident;
}
