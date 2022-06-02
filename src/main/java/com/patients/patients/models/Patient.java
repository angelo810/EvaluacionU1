package com.patients.patients.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PATIENTS")
@Getter
@Setter
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NAME")    
    private String name;
    @Column(name = "HEIGHT")    
    private float height;
    @Column(name = "WEIGHT")    
    private float weight;
    @Column(name = "DATE_OF_ADMISSION")    
    private String dateOfAdmission;
    @Column(name = "AGE")    
    private short age;

}
