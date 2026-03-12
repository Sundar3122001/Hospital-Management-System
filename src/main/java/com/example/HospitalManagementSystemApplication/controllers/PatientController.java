package com.example.HospitalManagementSystemApplication.controllers;
import com.example.HospitalManagementSystemApplication.models.Patient;
import com.example.HospitalManagementSystemApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
//        System.out.println("Fetching the patients");
        return null;
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("Creating patient");
        return patientService.createPatient(patient);
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
//        System.out.println("Searching the patient"+ " " +id);
        return patientService.getPatientById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        System.out.println("Deleted the patient"+ " " +id);
    }
    @PutMapping("/{id}")
    public String updatePatient(@PathVariable Long id){
        System.out.println("updating the patient"+ " " +id);
        return patientService.updatePatientById(id);
    }
}
