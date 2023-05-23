package com.example.Assignment.Repository;

import com.example.Assignment.Entity.Doctor;
import com.example.Assignment.Entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {
}

