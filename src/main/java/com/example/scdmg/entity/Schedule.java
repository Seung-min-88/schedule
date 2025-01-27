package com.example.scdmg.entity;

import com.example.scdmg.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Schedule {
    private Long id;
    private String name;
    private String todo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String password;
//    private String password;

    public Schedule(ScheduleRequestDto dto){
        this.name = dto.getName();
        this.todo = dto.getTodo();
        this.createTime = (dto.getCreateTime() != null) ? dto.getCreateTime() : LocalDateTime.now();
        this.updateTime = (dto.getUpdateTime() != null) ? dto.getUpdateTime() : this.createTime;
//        this.createTime = LocalDateTime.now();
//        this.updateTime = this.createTime;
        this.password = dto.getPassword();
    }

    public void update(ScheduleRequestDto dto){
        this.name = dto.getName();
        this.todo = dto.getTodo();
        this.updateTime = LocalDateTime.now();
    }

}
