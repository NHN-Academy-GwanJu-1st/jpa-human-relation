package com.nhnacademy.service;

import com.nhnacademy.domain.CertificateIssueDTO;

public interface CertificateIssueService {
    CertificateIssueDTO getCertificateInfoByResidentSerialNumber(Long certificateConfirmationNumber, String typeCode);
}
