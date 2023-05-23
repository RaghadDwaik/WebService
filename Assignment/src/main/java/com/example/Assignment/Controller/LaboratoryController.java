package com.example.Assignment.Controller;

import com.example.Assignment.Dto.LaboratoryDto;
import com.example.Assignment.Service.Inter.LaboratoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labs")
public class LaboratoryController {
    private final LaboratoryServices laboratoryService;

    public LaboratoryController(LaboratoryServices laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @PostMapping
    public ResponseEntity<LaboratoryDto> createLab(@RequestBody LaboratoryDto labDto) {
        LaboratoryDto createdLab = laboratoryService.createLab(labDto);
        return new ResponseEntity<>(createdLab, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LaboratoryDto>> getAllLabs() {
        List<LaboratoryDto> labs = laboratoryService.getAllLabs();
        return new ResponseEntity<>(labs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryDto> getLabById(@PathVariable("id") int id) {
        LaboratoryDto lab = laboratoryService.getLaboratoryById(id);
        return new ResponseEntity<>(lab, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaboratoryDto> updateLab(
            @PathVariable("id") int id, @RequestBody LaboratoryDto labDto) {
        LaboratoryDto updatedLab = laboratoryService.updateLab(labDto, id);
        return new ResponseEntity<>(updatedLab, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabById(@PathVariable("id") int id) {
        laboratoryService.deleteLaboratoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
