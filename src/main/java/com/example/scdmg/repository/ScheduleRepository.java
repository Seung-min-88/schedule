package com.example.scdmg.repository;

import com.example.scdmg.dto.ScheduleResponseDto;
import com.example.scdmg.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule (Schedule schedule);

    List<ScheduleResponseDto> findAllSchedule();

    Schedule findBtId(Long id);

    void deleteSchedule(Long id);
}
