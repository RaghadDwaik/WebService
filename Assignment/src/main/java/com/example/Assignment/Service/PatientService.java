package com.example.Assignment.Service;

import com.example.Assignment.Dto.DoctorDto;
import com.example.Assignment.Dto.PatientDto;
import com.example.Assignment.Entity.Doctor;
import com.example.Assignment.Entity.Patient;
import com.example.Assignment.Repository.DoctorRepository;
import com.example.Assignment.Repository.PatientRepository;
import com.example.Assignment.Service.Inter.DoctorServices;
import com.example.Assignment.Service.Inter.PatientServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements PatientServices {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setPatientName(patientDto.getPatientName());
        // Set other properties of the patient entity using patientDto

        Patient savedPatient = patientRepository.save(patient);

        return convertToDto(savedPatient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtos = new ArrayList<>();

        for (Patient patient : patients) {
            patientDtos.add(convertToDto(patient));
        }

        return patientDtos;
    }

    @Override
    public PatientDto getPatientById(int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient with id " + id + " not found"));

        return convertToDto(patient);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient with id " + id + " not found"));

        // Update the patient entity with the new values from patientDto
        patient.setPatientName(patientDto.getPatientName());
        // Update other properties of the patient entity using patientDto

        Patient updatedPatient = patientRepository.save(patient);

        return convertToDto(updatedPatient);
    }

    @Override
    public void deletePatientById(int id) {
        patientRepository.deleteById(id);
    }

    private PatientDto convertToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientId(patient.getPatientId());
        patientDto.setPatientName(patient.getPatientName());
        // Set other properties of the patientDto using patient entity

        return patientDto;
    }
}
