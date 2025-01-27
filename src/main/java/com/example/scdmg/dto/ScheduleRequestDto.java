package com.example.scdmg.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ScheduleRequestDto {
    private String name;
    private String todo;
    private LocalDateTime creDate;
}
