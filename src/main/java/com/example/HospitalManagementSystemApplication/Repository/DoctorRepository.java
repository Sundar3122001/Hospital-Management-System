package com.example.HospitalManagementSystemApplication.repository;

import com.example.HospitalManagementSystemApplication.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}