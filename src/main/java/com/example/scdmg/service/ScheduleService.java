package com.example.scdmg.service;

import com.example.scdmg.dto.ScheduleRequestDto;
import com.example.scdmg.dto.ScheduleResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAllSchedule();

    ScheduleResponseDto findById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String name, String todo, LocalDateTime updateTime, String password);

    void deleteSchedule(Long id);

    boolean checkPassword(Long id, String password);
}
