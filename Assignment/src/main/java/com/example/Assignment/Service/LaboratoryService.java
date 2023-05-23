package com.example.Assignment.Service;

import com.example.Assignment.Dto.LaboratoryDto;
import com.example.Assignment.Entity.Laboratory;
import com.example.Assignment.Repository.LaboratoryRepository;
import com.example.Assignment.Service.Inter.LaboratoryServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LaboratoryService implements LaboratoryServices {
    private final LaboratoryRepository laboratoryRepository;

    public LaboratoryService(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    @Override
    public LaboratoryDto createLab(LaboratoryDto labDto) {
        Laboratory laboratory = mapToEntity(labDto);
        Laboratory newLab = laboratoryRepository.save(laboratory);
        return mapToDto(newLab);
    }

    @Override
    public List<LaboratoryDto> getAllLabs() {
        List<Laboratory> labs = laboratoryRepository.findAll();
        return mapToDtoList(labs);
    }

    @Override
    public LaboratoryDto getLaboratoryById(int id) {
        Laboratory lab = laboratoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Laboratory not found with id: " + id));
        return mapToDto(lab);
    }

    @Override
    public LaboratoryDto updateLab(LaboratoryDto labDto, int id) {
        Laboratory existingLab = laboratoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Laboratory not found with id: " + id));
        Laboratory updatedLab = mapToEntity(labDto);
        updatedLab.setLabid(existingLab.getLabid());
        Laboratory savedLab = laboratoryRepository.save(updatedLab);
        return mapToDto(savedLab);
    }

    @Override
    public void deleteLaboratoryById(int id) {
        laboratoryRepository.deleteById(id);
    }

    // Helper methods for mapping between entities and DTOs
    private Laboratory mapToEntity(LaboratoryDto labDto) {
        Laboratory lab = new Laboratory();
        lab.setStatus(labDto.getStatus());
        // Set other attributes of the laboratory entity based on the DTO
        return lab;
    }

    private LaboratoryDto mapToDto(Laboratory lab) {
        LaboratoryDto labDto = new LaboratoryDto();
        labDto.setLabid(lab.getLabid());
        labDto.setStatus(lab.getStatus());
        // Set other attributes of the DTO based on the laboratory entity
        return labDto;
    }

    private List<LaboratoryDto> mapToDtoList(List<Laboratory> labs) {
        List<LaboratoryDto> labDtos = new ArrayList<>();
        for (Laboratory lab : labs) {
            labDtos.add(mapToDto(lab));
        }
        return labDtos;
    }
}
