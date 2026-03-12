package com.example.HospitalManagementSystemApplication.service;

import com.example.HospitalManagementSystemApplication.models.Appointment;
import com.example.HospitalManagementSystemApplication.models.Patient;
import com.example.HospitalManagementSystemApplication.models.Doctor;
import com.example.HospitalManagementSystemApplication.repository.AppointmentRepository;
import com.example.HospitalManagementSystemApplication.repository.PatientRepository;
import com.example.HospitalManagementSystemApplication.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment createAppointment(Long patientId, Long doctorId, Appointment appointment){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        if(appointment.getStatus() == null){
            appointment.setStatus("Scheduled");
        }

        return appointmentRepository.save(appointment);
    }

    public Page<Appointment> getAllAppointments(int page, int size){

        Pageable pageable = PageRequest.of(page, size);

        return appointmentRepository.findAll(pageable);
    }

    public Appointment getAppointmentById(Long id){

        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void deleteAppointment(Long id){

        if(!appointmentRepository.existsById(id)){
            throw new RuntimeException("Appointment not found");
        }

        appointmentRepository.deleteById(id);
    }
}