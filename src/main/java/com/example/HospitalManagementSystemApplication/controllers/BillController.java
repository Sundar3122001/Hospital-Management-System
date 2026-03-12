package com.example.HospitalManagementSystemApplication.controllers;

import com.example.HospitalManagementSystemApplication.models.Bill;
import com.example.HospitalManagementSystemApplication.service.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public Bill generateBill(
            @RequestParam Long appointmentId,
            @RequestBody Bill bill){

        return billService.generateBill(appointmentId, bill);
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id){
        return billService.getBill(id);
    }
}