package com.nhnacademy.service;

import com.nhnacademy.domain.CertificateIssueDTO;
import com.nhnacademy.entity.CertificateIssue;
import com.nhnacademy.exception.NotExistCertificateException;
import com.nhnacademy.repository.CertificateIssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CertificateIssueServiceImpl implements CertificateIssueService {

    private final CertificateIssueRepository certificateIssueRepository;

    @Override
    public CertificateIssueDTO getCertificateInfoByResidentSerialNumber(Long certificateConfirmationNumber, String typeCode) {
        return certificateIssueRepository.getCertificateInfoByResidentSerialNumber(certificateConfirmationNumber, typeCode);
    }
}
