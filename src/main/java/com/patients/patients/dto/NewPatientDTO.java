package com.patients.patients.dto;



import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewPatientDTO {
    @NotNull(message = "Name width can't be null.")
    private String name;
    @NotNull(message = "height width can't be null.")
    private float height;
    @NotNull(message = "weight width can't be null.")
    private float weight; 
    @NotNull(message = "weight width can't be null.")
    private LocalDate dateOfAdmission;  
    @Min(message = "Age can't be lower 0 age", value = 0)
    @Max(message = "Age can't be more 60 age",value = 60)
    private short age;   

}