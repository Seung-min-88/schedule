package com.example.scdmg.entitiy;

import com.example.scdmg.dto.ScheduleRequestDto;
import com.example.scdmg.dto.ScheduleResponseDto;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@Timestamp
public class Schedule {

    private Long id;
    private String todo;
    private String name;
    private LocalDateTime credate;

//    private Date creDate;
//    private String password;


    public void update(ScheduleRequestDto dto){
        this.todo = dto.getTodo();
    }

    public LocalDateTime getCreDate() {
        return credate;
    }
}
