package com.example.HospitalManagementSystemApplication.controllers;

import com.example.HospitalManagementSystemApplication.models.Doctor;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @GetMapping
    public Doctor getDoctor(){
        System.out.println("getting the doctor");
        return null;
    }
    @GetMapping("/{id}")
    public void getDoctorById(@PathVariable Long id){
        System.out.println("Searching the doctor by id "+id);
    }

    @PostMapping
    public void createDoctor(@RequestBody Doctor doctor){
        System.out.println("Created the new doctor");

    }
    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id){
        System.out.println("Updated the doctor"+ " " +id);
    }
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        System.out.println("Deleted the doctor"+ " " +id);
    }
}
