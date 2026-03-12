package com.example.HospitalManagementSystemApplication.service;

import com.example.HospitalManagementSystemApplication.Repository.PatientRepository;
import com.example.HospitalManagementSystemApplication.models.Patient;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    private static final Logger logger= LoggerFactory.getLogger(PatientService.class);

    public Patient createPatient(Patient patient){
        try{
            Patient savedPatient = patientRepository.save(patient);
            logger.info("Creating patient in service layer");
            return savedPatient;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    public Page<Patient> getAllPatient(int page, int size){
        try{
            Pageable pageable = PageRequest.of(page, size);
            logger.info("Fetching all patients from service layer");
            return patientRepository.findAll(pageable);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Patient getPatientById(Long id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public String updatePatientById(Long id, Patient patient){

        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        patientRepository.save(existingPatient);
        return "Patient updated successfully";
    }

    @Transactional
    public String deletePatientById(Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        patientRepository.delete(patient);
        logger.info("Deleting patient with id: {}", id);
        return "Patient deleted successfully";
    }

}
