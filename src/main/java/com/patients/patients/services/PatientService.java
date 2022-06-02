package com.patients.patients.services;

import java.util.List;

import com.patients.patients.dto.NewPatientDTO;
import com.patients.patients.dto.PatientDTO;

public interface PatientService {
    public PatientDTO create(NewPatientDTO patientDTO);
    public PatientDTO retrieve(Long id);
    
    public List<PatientDTO> list();
}
