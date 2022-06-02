package com.patients.patients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patients.patients.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
