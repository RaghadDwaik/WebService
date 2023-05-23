package com.example.Assignment.Controller;

import com.example.Assignment.Dto.DoctorDto;
import com.example.Assignment.Exception.BadRequestException;
import com.example.Assignment.Service.DoctorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final Logger log = LoggerFactory.getLogger(DoctorController.class);

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable(name = "id") int id) {
        DoctorDto doctorDto = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctorDto);
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        if (doctorDto.getDoctorId() > 0) {
            log.error("Cannot specify ID for a new doctor: {}", doctorDto);
            throw new BadRequestException(DoctorController.class.getSimpleName(), "doctorId");
        }
        DoctorDto createdDoctorDto = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(createdDoctorDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(
            @Valid @RequestBody DoctorDto doctorDto, @PathVariable(name = "id") int id) {
        DoctorDto updatedDoctorDto = doctorService.updateDoctor(doctorDto, id);
        return ResponseEntity.ok(updatedDoctorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable(name = "id") int id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>("Doctor deleted successfully.", HttpStatus.OK);
    }
}
