package com.example.Assignment.Repository;

import com.example.Assignment.Entity.Doctor;
import com.example.Assignment.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
