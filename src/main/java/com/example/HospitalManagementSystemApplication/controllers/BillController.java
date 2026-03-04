package com.example.HospitalManagementSystemApplication.controllers;

import com.example.HospitalManagementSystemApplication.models.Bill;
import com.example.HospitalManagementSystemApplication.models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/bill")
public class BillController {
    @GetMapping
    public List<Bill> getAllBill(){
        System.out.println("Fetching the Bills");
        return null;
    }
    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        System.out.println("Creating Bill");
        return bill;
    }
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        System.out.println("Searching the Bill"+ " " +id);
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id){
        System.out.println("Deleted the Bill"+ " " +id);
    }
    @PutMapping("/{id}")
    public void updateBill(@PathVariable Long id){
        System.out.println("updating the Bill"+ " " +id);
    }
}

