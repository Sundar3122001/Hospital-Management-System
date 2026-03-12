package com.example.HospitalManagementSystemApplication.service;

import com.example.HospitalManagementSystemApplication.models.Doctor;
import com.example.HospitalManagementSystemApplication.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Page<Doctor> getAllDoctors(int page, int size){

        Pageable pageable = PageRequest.of(page, size);

        return doctorRepository.findAll(pageable);
    }

    public Doctor getDoctorById(Long id){

        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails){

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setExperience(doctorDetails.getExperience());
        doctor.setConsultationFee(doctorDetails.getConsultationFee());

        return doctorRepository.save(doctor);
    }

    public String deleteDoctor(Long id){

        if(!doctorRepository.existsById(id)){
            throw new RuntimeException("Doctor not found");
        }

        doctorRepository.deleteById(id);

        return "Doctor deleted successfully";
    }
}