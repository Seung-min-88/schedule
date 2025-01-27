package com.example.scdmg.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter

public class ScheduleRequestDto {
    private Long id;
    private String name;
    private String todo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String password;
//    private String password;
}
