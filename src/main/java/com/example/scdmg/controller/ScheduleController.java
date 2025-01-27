package com.example.scdmg.controller;

import com.example.scdmg.dto.ScheduleRequestDto;
import com.example.scdmg.dto.ScheduleResponseDto;
import com.example.scdmg.entity.Schedule;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {

        // 식별자 아이디가 1씩 증가
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 요청한 데이터로 스케줄 객체 생성
        Schedule schedule = new Schedule(dto);

        // 스케줄 클래스에 세터를 만들어 세터로 생성자에 scheduleId를 넣음
        schedule.setId(scheduleId);
        // Inmemory DB에 Memo 메모

        // 리스트에 따로 넣은 아이디와 스케줄을 넣음
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
    public void deleteSchedule(
            @PathVariable Long id){
//            @PathParam(String password) String password{


        scheduleList.remove(id);
    }

//    @GetMapping("/all")
//    public List<ScheduleResponseDto> findAllSchedule() {
//
//        List<ScheduleResponseDto> responseList = new ArrayList<>();
//
//        for(Schedule schedule : scheduleList.values()) {
//            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
//            responseList.add(responseDto);
//        }
//
//        return responseList;
//    }
}
