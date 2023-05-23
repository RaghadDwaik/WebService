package com.example.Assignment.Service.Inter;

import com.example.Assignment.Dto.ReceptionDto;

import java.util.List;

public interface ReceptionServices {
    ReceptionDto createReception(ReceptionDto receptionDto);

    List<ReceptionDto> getAllReceptions();

    ReceptionDto getReceptionById(int id);

    ReceptionDto updateReception(int id, ReceptionDto receptionDto);

    void deleteReceptionById(int id);
}
