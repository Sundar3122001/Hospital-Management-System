package com.example.HospitalManagementSystemApplication.service;

import com.example.HospitalManagementSystemApplication.models.Patient;
import com.example.HospitalManagementSystemApplication.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Page<Patient> getAllPatients(int page, int size){

        Pageable pageable = PageRequest.of(page, size);

        return patientRepository.findAll(pageable);
    }

    public Patient getPatientById(Long id){

        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient updatePatient(Long id, Patient patientDetails){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(patientDetails.getName());
        patient.setAge(patientDetails.getAge());
        patient.setPhone(patientDetails.getPhone());
        patient.setDisease(patientDetails.getDisease());
        patient.setAddress(patientDetails.getAddress());

        return patientRepository.save(patient);
    }

    public void deletePatient(Long id){

        if(!patientRepository.existsById(id)){
            throw new RuntimeException("Patient not found");
        }

        patientRepository.deleteById(id);
    }
}