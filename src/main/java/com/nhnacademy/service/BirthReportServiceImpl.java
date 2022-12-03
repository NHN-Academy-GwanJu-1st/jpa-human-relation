package com.nhnacademy.service;

import com.nhnacademy.domain.BirthReportDTO;
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
public class BirthReportServiceImpl implements BirthReportService {

    private final ResidentRepository residentRepository;
    private final BirthDeathReportResidentRepository birthReportRepository;

    private static final String BIRTH_TYPE_CODE = "출생";

    @Override
    public BirthDeathReportResident registerBirthReport(BirthReportDTO birthReportDTO) {

        // serialNumber -> 신고한사람
        // birthReportDTO.getReportResidentSerialNumber = serialNumber;
        // birthReportDTO.getResidentSerialNumber -> 신고 당한 사람 즉, 태어나거나 죽은 사람

        Resident reportResident = residentRepository.findById(birthReportDTO.getReportResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);
        Resident targetResident = residentRepository.findById(birthReportDTO.getResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);


        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident().builder()
                .pk(new BirthDeathReportResident.Pk(targetResident.getResidentSerialNumber(), birthReportDTO.getBirthDeathTypeCode()))
                .resident(targetResident)
                .reportResidentSerialNumber(reportResident)
                .birthDeathReportDate(birthReportDTO.getBirthDeathReportDate())
                .birthReportQualificationsCode(birthReportDTO.getBirthReportQualificationsCode())
                .emailAddress(birthReportDTO.getEmailAddress())
                .phoneNumber(birthReportDTO.getPhoneNumber())
                .build();

        return birthReportRepository.save(birthDeathReportResident);
    }

    @Override
    public BirthDeathReportResident modifyBirthReport(Long targetSerialNumber, BirthReportDTO birthReportDTO) {

        BirthDeathReportResident birthReport =
                birthReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, BIRTH_TYPE_CODE);

        if (Objects.isNull(birthReport)) {
            throw new NotFoundResidentException();
        }

        birthReport.updateReportInfo(birthReportDTO.getEmailAddress(), birthReportDTO.getPhoneNumber());

        return birthReportRepository.save(birthReport);
    }

    @Override
    public void deleteBirthReport(Long targetSerialNumber) {
        birthReportRepository
                .deleteByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, BIRTH_TYPE_CODE);

    }
}
