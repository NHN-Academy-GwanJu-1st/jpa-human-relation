package com.nhnacademy.repository;

import com.nhnacademy.entity.HouseholdCompositionResident;
import com.nhnacademy.entity.QHousehold;
import com.nhnacademy.entity.QHouseholdCompositionResident;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class HouseholdCompositionResidentRepositoryImpl extends QuerydslRepositorySupport implements HouseholdCompositionResidentRepositoryCustom {

    public HouseholdCompositionResidentRepositoryImpl() {
        super(HouseholdCompositionResident.class);
    }

    @Override
    public List<HouseholdCompositionResident> getHouseholdCompositionByHouseholdResidentSerialNumber(Long residentSerialNumber) {
        QHouseholdCompositionResident householdCompositionResident = QHouseholdCompositionResident.householdCompositionResident;

        return from(householdCompositionResident)
                .select(householdCompositionResident)
                .where(householdCompositionResident.household.householdResidentSerialNumber.residentSerialNumber.eq(residentSerialNumber))
                .fetch();
    }
}
