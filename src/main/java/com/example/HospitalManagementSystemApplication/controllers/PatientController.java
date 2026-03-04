package com.example.HospitalManagementSystemApplication.controllers;
import com.example.HospitalManagementSystemApplication.models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    @GetMapping
    public List<Patient> getAllPatients(){
        System.out.println("Fetching the patients");
        return null;
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("Creating patient");
        return patient;
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        System.out.println("Searching the patient"+ " " +id);
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        System.out.println("Deleted the patient"+ " " +id);
    }
    @PutMapping("/{id}")
    public void updatePatient(@PathVariable Long id){
        System.out.println("updating the patient"+ " " +id);
    }
}
