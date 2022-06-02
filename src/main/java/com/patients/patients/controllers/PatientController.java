package com.patients.patients.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patients.patients.dto.NewPatientDTO;
import com.patients.patients.dto.PatientDTO;
import com.patients.patients.services.PatientService;
@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;
  
    @Autowired
    public PatientController(PatientService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<PatientDTO> create(@Valid @RequestBody NewPatientDTO patientDTO){
        PatientDTO result = service.create(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @NotBlank(message = "Name width can't be null.")
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> retrive(@PathVariable("id") Long id){
        PatientDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<PatientDTO>> list(){
        List<PatientDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

}
