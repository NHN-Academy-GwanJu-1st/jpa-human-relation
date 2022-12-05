package com.nhnacademy.repository;

import com.nhnacademy.entity.HouseholdMovementAddress;
import com.nhnacademy.entity.QHousehold;
import com.nhnacademy.entity.QHouseholdMovementAddress;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class HouseholdMovementAddressRepositoryImpl extends QuerydslRepositorySupport implements HouseholdMovementAddressRepositoryCustom {

    public HouseholdMovementAddressRepositoryImpl() {
        super(HouseholdMovementAddress.class);
    }

    @Override
    public HouseholdMovementAddress getLastMovementAddress(Long householdSerialNumber) {
        QHouseholdMovementAddress householdMovementAddress = QHouseholdMovementAddress.householdMovementAddress;

        return from(householdMovementAddress)
                .select(householdMovementAddress)
                .where(householdMovementAddress.pk.householdSerialNumber.eq(householdSerialNumber))
                .orderBy(householdMovementAddress.pk.houseMovementReportDate.desc())
                .limit(1)
                .fetchOne();
    }

    @Override
    public List<HouseholdMovementAddress> getMovementAddressByResidentSerialNumber(Long residentSerialNumber) {

        QHouseholdMovementAddress householdMovementAddress = QHouseholdMovementAddress.householdMovementAddress;
        QHousehold household = QHousehold.household;

        return from(household)
                .select(householdMovementAddress)
                .innerJoin(household, householdMovementAddress.household)
                .where(household.householdResidentSerialNumber.residentSerialNumber.eq(residentSerialNumber))
                .fetch();
//        return null;
    }
}
