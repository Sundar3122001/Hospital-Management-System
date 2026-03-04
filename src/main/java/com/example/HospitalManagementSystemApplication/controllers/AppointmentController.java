package com.example.HospitalManagementSystemApplication.controllers;

import com.example.HospitalManagementSystemApplication.models.Appointment;
import com.example.HospitalManagementSystemApplication.models.Bill;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
    @GetMapping
    public List<Appointment> getAllAppointment(){
        System.out.println("Fetching the appointments");
        return null;
    }
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        System.out.println("Creating appointment");
        return appointment;
    }
    @GetMapping("/{id}")
    public Bill getAppointmentById(@PathVariable Long id){
        System.out.println("Searching the appointment"+ " " +id);
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        System.out.println("Deleted the appointment"+ " " +id);
    }
    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable Long id){
        System.out.println("updating the appointment"+ " " +id);
    }
}
