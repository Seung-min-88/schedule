package com.example.scdmg.controller;

import com.example.scdmg.dto.ScheduleRequestDto;
import com.example.scdmg.dto.ScheduleResponseDto;
import com.example.scdmg.entitiy.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        Schedule schedule = new Schedule(scheduleId, dto.getTodo(), dto.getName(), dto.getCreDate());

        scheduleList.put(scheduleId, schedule);

        return new ScheduleResponseDto(schedule);
    }

    @GetMapping("/{id}")
    public ScheduleResponseDto findById(@PathVariable Long id) {
        Schedule schedule = scheduleList.get(id);
        return new ScheduleResponseDto(schedule);
    }

    @PutMapping("/{id}")
    public ScheduleResponseDto updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ){
        Schedule schedule = scheduleList.get(id);

        schedule.update(dto);
        return new ScheduleResponseDto(schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id){
        scheduleList.remove(id);
    }
}
