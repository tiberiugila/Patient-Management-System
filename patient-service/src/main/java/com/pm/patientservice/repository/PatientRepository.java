package com.pm.patientservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.pm.patientservice.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
