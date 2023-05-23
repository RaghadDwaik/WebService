package com.example.Assignment.Service.Inter;

import com.example.Assignment.Dto.DoctorDto;
import com.example.Assignment.Dto.LaboratoryDto;

import java.util.List;

public interface LaboratoryServices {


    LaboratoryDto createLab(LaboratoryDto labDto);

    List<LaboratoryDto> getAllLabs();

    LaboratoryDto getLaboratoryById(int id);

    LaboratoryDto updateLab(LaboratoryDto labDto, int id);

    void deleteLaboratoryById(int id);



}
