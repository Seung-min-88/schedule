package com.example.scdmg.dto;

import com.example.scdmg.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String todo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.todo = schedule.getTodo();
        this.createTime = schedule.getCreateTime();
        this.updateTime = schedule.getUpdateTime();
    }
}

