package com.example.Assignment.Repository;

import com.example.Assignment.Entity.Patient;
import com.example.Assignment.Entity.Reception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionRepository extends JpaRepository<Reception, Integer> {
}
