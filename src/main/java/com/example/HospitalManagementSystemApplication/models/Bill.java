package com.example.HospitalManagementSystemApplication.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double consultationFee;

    private double medicineCost;

    private double totalAmount;

    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}