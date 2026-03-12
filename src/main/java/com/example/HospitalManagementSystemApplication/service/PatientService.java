package com.example.HospitalManagementSystemApplication.service;

import com.example.HospitalManagementSystemApplication.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {

    private static final Logger logger= LoggerFactory.getLogger(PatientService.class);

    public Patient createPatient(Patient patient){
        try{
            logger.info("creating patient in the into service layer class ");
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> getAllPatient(){
        try{
            logger.info("fetching the all patients in service class ");
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Patient getPatientById(Long id){
        try{
            System.out.println("into service class ");
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public String updatePatientById(Long id){
        try{
            System.out.println(" updating the patient by id into service class ");
            return "Patient updated by id";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Patient deletePatientById(Long id){
        try{
            System.out.println("deleting the patient in service ");
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
