package com.example.HospitalManagementSystemApplication.service;

import com.example.HospitalManagementSystemApplication.models.Appointment;
import com.example.HospitalManagementSystemApplication.models.Bill;
import com.example.HospitalManagementSystemApplication.repository.AppointmentRepository;
import com.example.HospitalManagementSystemApplication.repository.BillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Bill generateBill(Long appointmentId, Bill bill){

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
//        Appointment appointment = appointmentRepository.findById(appointmentId)
//                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        bill.setAppointment(appointment);

        double total = bill.getConsultationFee() + bill.getMedicineCost();

        bill.setTotalAmount(total);

        return billRepository.save(bill);
    }

    public Bill getBill(Long id){

        return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
    }
}