package com.example.Assignment.Service;

import com.example.Assignment.Dto.DoctorDto;
import com.example.Assignment.Entity.Doctor;
import com.example.Assignment.Repository.DoctorRepository;
import com.example.Assignment.Service.Inter.DoctorServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService implements DoctorServices {
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        Doctor newDoctor = doctorRepository.save(doctor);
        DoctorDto doctorResponse = mapToDTO(newDoctor);
        return doctorResponse;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return mapToDTOList(doctors);
    }

    @Override
    public void deleteDoctorById(int id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDto getDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor == null) {
            throw new EntityNotFoundException("Doctor not found with id: " + id);
        }
        return mapToDTO(doctor);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, int id) {
        Doctor existingDoctor = doctorRepository.findById(id).orElse(null);
        if (existingDoctor == null) {
            throw new EntityNotFoundException("Doctor not found with id: " + id);
        }
        Doctor updatedDoctor = mapToEntity(doctorDto);
        updatedDoctor.setDoctorId(id);
        Doctor savedDoctor = doctorRepository.save(updatedDoctor);
        return mapToDTO(savedDoctor);
    }

    // Helper methods for mapping between entities and DTOs
    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setStatus(doctorDto.getStatus());
        doctor.setTel(doctorDto.getTel());
        return doctor;
    }

    private DoctorDto mapToDTO(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctorId(doctor.getDoctorId());
        doctorDto.setDoctorName(doctor.getDoctorName());
        doctorDto.setTel(doctor.getTel());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setStatus(doctor.getStatus());
        return doctorDto;
    }

    private List<DoctorDto> mapToDTOList(List<Doctor> doctors) {
        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDtos.add(mapToDTO(doctor));
        }
        return doctorDtos;
    }
}
