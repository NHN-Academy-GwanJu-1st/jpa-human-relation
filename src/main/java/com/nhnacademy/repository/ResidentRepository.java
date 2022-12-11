package com.nhnacademy.repository;

import com.nhnacademy.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ResidentRepository extends JpaRepository<Resident, Long> {

    Optional<Resident> findByResidentId(String residentId);

    Optional<Resident> findByEmail(String email);

}
