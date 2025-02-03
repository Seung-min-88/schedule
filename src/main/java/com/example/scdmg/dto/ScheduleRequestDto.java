package com.example.scdmg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    private Long id;
    private String name;
    private String todo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String password;

}
