package com.example.scdmg.repository;

import com.example.scdmg.dto.ScheduleResponseDto;
import com.example.scdmg.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedule();

    Optional<Schedule> findById(Long id);

    void deleteSchedule(Long id);

    int updateSchedule(Long id, String name, String todo);

    Schedule findByIdOrElseThrow(Long id);
}
