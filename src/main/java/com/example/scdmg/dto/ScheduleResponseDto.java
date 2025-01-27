package com.example.scdmg.dto;

import com.example.scdmg.entitiy.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String todo;
    private LocalDateTime creDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.todo = schedule.getTodo();
        this.name = schedule.getName();
        this.creDate = schedule.getCreDate();
    }
}

