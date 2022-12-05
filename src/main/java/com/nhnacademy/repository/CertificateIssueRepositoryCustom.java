package com.nhnacademy.repository;

import com.nhnacademy.domain.CertificateIssueDTO;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CertificateIssueRepositoryCustom {
    CertificateIssueDTO getCertificateInfoByResidentSerialNumber(Long serialNumber, String typeCode);
}
