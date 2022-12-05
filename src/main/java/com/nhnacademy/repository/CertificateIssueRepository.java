package com.nhnacademy.repository;

import com.nhnacademy.domain.CertificateIssueDTO;
import com.nhnacademy.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long>, CertificateIssueRepositoryCustom{

}
