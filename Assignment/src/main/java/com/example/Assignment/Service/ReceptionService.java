package com.example.Assignment.Service;

import com.example.Assignment.Dto.ReceptionDto;
import com.example.Assignment.Entity.Reception;
import com.example.Assignment.Repository.ReceptionRepository;
import com.example.Assignment.Service.Inter.ReceptionServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceptionService implements ReceptionServices {
    private final ReceptionRepository receptionRepository;

    public ReceptionService(ReceptionRepository receptionRepository) {
        this.receptionRepository = receptionRepository;
    }

    @Override
    public ReceptionDto createReception(ReceptionDto receptionDto) {
        Reception reception = mapToEntity(receptionDto);
        Reception newReception = receptionRepository.save(reception);
        ReceptionDto receptionResponse = mapToDto(newReception);
        return receptionResponse;
    }

    @Override
    public List<ReceptionDto> getAllReceptions() {
        List<Reception> receptions = receptionRepository.findAll();
        return mapToDtoList(receptions);
    }

    @Override
    public ReceptionDto getReceptionById(int id) {
        Reception reception = receptionRepository.findById(id).orElse(null);
        if (reception == null) {
            throw new EntityNotFoundException("Reception not found with id: " + id);
        }
        return mapToDto(reception);
    }

    @Override
    public ReceptionDto updateReception(int id, ReceptionDto receptionDto) {
        Reception existingReception = receptionRepository.findById(id).orElse(null);
        if (existingReception == null) {
            throw new EntityNotFoundException("Reception not found with id: " + id);
        }
        Reception updatedReception = mapToEntity(receptionDto);
        updatedReception.setId(id);
        Reception savedReception = receptionRepository.save(updatedReception);
        return mapToDto(savedReception);
    }

    @Override
    public void deleteReceptionById(int id) {
        receptionRepository.deleteById(id);
    }

    private Reception mapToEntity(ReceptionDto receptionDto) {
        Reception reception = new Reception();
        reception.setPatientName(receptionDto.getPatientName());
        reception.setDoctorName(receptionDto.getDoctorName());
        reception.setAppointmentTime(receptionDto.getAppointmentDate());
        return reception;
    }

    private ReceptionDto mapToDto(Reception reception) {
        ReceptionDto receptionDto = new ReceptionDto();
        receptionDto.setId(reception.getId());
        receptionDto.setPatientName(reception.getPatientName());
        receptionDto.setDoctorName(reception.getDoctorName());
        receptionDto.setAppointmentDate(reception.getAppointmentTime());
        return receptionDto;
    }

    private List<ReceptionDto> mapToDtoList(List<Reception> receptions) {
        List<ReceptionDto> receptionDtos = new ArrayList<>();
        for (Reception reception : receptions) {
            receptionDtos.add(mapToDto(reception));
        }
        return receptionDtos;
    }
}
