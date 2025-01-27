package com.example.scdmg.repository;

import com.example.scdmg.dto.ScheduleResponseDto;
import com.example.scdmg.entity.Schedule;

import java.util.List;

public class JdbcTemplateScheduleRepository implements ScheduleRepository{
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        return null;
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return List.of();
    }

    @Override
    public Schedule findBtId(Long id) {
        return null;
    }

    @Override
    public void deleteSchedule(Long id) {

    }
}
