package com.nhnacademy.service;

import com.nhnacademy.domain.BirthReportDTO;
import com.nhnacademy.entity.BirthDeathReportResident;
import com.nhnacademy.repository.BirthReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BirthReportServiceImpl implements BirthReportService {

    private final BirthReportRepository birthReportRepository;

    @Override
    public BirthDeathReportResident registerBirthReport(Long serialNumber, BirthReportDTO birthReportDTO) {
        return null;
    }
}
