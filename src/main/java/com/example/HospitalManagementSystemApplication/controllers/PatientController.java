package com.example.HospitalManagementSystemApplication.controllers;
import com.example.HospitalManagementSystemApplication.models.Patient;
import com.example.HospitalManagementSystemApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public Page<Patient> getAllPatients(@RequestParam(defaultValue="0")int page,
                                        @RequestParam(defaultValue = "2")int size){
        return patientService.getAllPatient(page,size);
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
        patientService.deletePatientById(id);
    }
    @PutMapping("/{id}")
    public String updatePatient(@PathVariable Long id ,@RequestBody Patient patient){
        System.out.println("updating the patient"+ " " +id);
        return patientService.updatePatientById(id, patient);
    }
}
