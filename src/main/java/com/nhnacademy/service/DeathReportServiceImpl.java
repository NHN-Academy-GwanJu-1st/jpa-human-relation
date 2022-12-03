package com.nhnacademy.service;

import com.nhnacademy.domain.BirthReportDTO;
import com.nhnacademy.domain.DeathReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.exception.NotFoundResidentException;
import com.nhnacademy.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class DeathReportServiceImpl implements DeathReportService {

    private final ResidentRepository residentRepository;
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;

    private static final String DEATH_TYPE_CODE = "사망";

    @Override
    public BirthDeathReportResident registerDeathReport(DeathReportDTO deathReportDTO) {

        Resident reportResident = residentRepository.findById(deathReportDTO.getReportResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);
        Resident targetResident = residentRepository.findById(deathReportDTO.getResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);


        BirthDeathReportResident deathReport = new BirthDeathReportResident().builder()
                .pk(new BirthDeathReportResident.Pk(targetResident.getResidentSerialNumber(), deathReportDTO.getBirthDeathTypeCode()))
                .resident(targetResident)
                .reportResidentSerialNumber(reportResident)
                .birthDeathReportDate(deathReportDTO.getBirthDeathReportDate())
                .birthReportQualificationsCode(deathReportDTO.getDeathReportQualificationsCode())
                .emailAddress(deathReportDTO.getEmailAddress())
                .phoneNumber(deathReportDTO.getPhoneNumber())
                .build();

        return birthDeathReportResidentRepository.save(deathReport);
    }

    @Override
    public BirthDeathReportResident modifyDeathReport(Long targetSerialNumber, DeathReportDTO deathReportDTO) {
        BirthDeathReportResident deathReport =
                birthDeathReportResidentRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, DEATH_TYPE_CODE);

        if (Objects.isNull(deathReport)) {
            throw new NotFoundResidentException();
        }

        deathReport.updateReportInfo(deathReport.getEmailAddress(), deathReport.getPhoneNumber());

        return birthDeathReportResidentRepository.save(deathReport);
    }

    @Override
    public void deleteDeathReport(Long targetSerialNumber) {
        birthDeathReportResidentRepository
                .deleteByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, DEATH_TYPE_CODE);

    }
}
