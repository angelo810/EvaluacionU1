package com.patients.patients.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patients.patients.dto.NewPatientDTO;
import com.patients.patients.dto.PatientDTO;
import com.patients.patients.exceptions.ResourceNotFoundException;
import com.patients.patients.models.Patient;
import com.patients.patients.repositories.PatientRepository;
import com.patients.patients.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    final ModelMapper modelMapper;
    final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(@Autowired PatientRepository repository, ModelMapper mapper){
        this.patientRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public PatientDTO create(NewPatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patientRepository.save(patient);        
        return modelMapper.map(patient, PatientDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public PatientDTO retrieve(Long id) {
        Patient patient = patientRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Patient not found"));
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientDTO> list() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(patient -> modelMapper.map(patient, PatientDTO.class))
            .collect(Collectors.toList());        
    }
}
