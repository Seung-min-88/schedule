package com.example.scdmg.entity;

import com.example.scdmg.dto.ScheduleRequestDto;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Schedule {
    private Long id;
    private String name;
    private String todo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String password;

    public Schedule(ScheduleRequestDto dto){
        this.name = dto.getName();
        this.todo = dto.getTodo();
        this.createTime = (dto.getCreateTime() != null) ? dto.getCreateTime() : LocalDateTime.now();
        this.updateTime = (dto.getUpdateTime() != null) ? dto.getUpdateTime() : this.createTime;
        this.password = dto.getPassword();
    }

    public Schedule(Long id, String name, String todo, String password){
        this.id = id;
        this.name = name;
        this.todo = todo;
        this.password = password;
    }

}
