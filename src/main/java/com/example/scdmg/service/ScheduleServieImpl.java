package com.example.scdmg.service;


import com.example.scdmg.dto.ScheduleRequestDto;
import com.example.scdmg.dto.ScheduleResponseDto;
import com.example.scdmg.entity.Schedule;
import com.example.scdmg.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServieImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;


    public ScheduleServieImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto);
        return scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {

        List<ScheduleResponseDto> allSchedule = scheduleRepository.findAllSchedule();
        return allSchedule;
    }

    @Override
    public ScheduleResponseDto findById(Long id) {

        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if (optionalSchedule == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        return new ScheduleResponseDto(optionalSchedule.get());
    }

    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String name, String todo, LocalDateTime updateTime) {

        if (name == null || todo == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        int updateRow = scheduleRepository.updateSchedule(id,name,todo);

        if (updateRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data has been modified.");
        }

        return new ScheduleResponseDto(scheduleRepository.findById(id).get());
    }

    @Override
    public void deleteSchedule(Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (!optionalSchedule.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        scheduleRepository.deleteSchedule(id);
    }

    @Override
    public boolean checkPassword(Long id, String password) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        String dbPassword = schedule.getPassword();
        if (dbPassword == null) {
            return false;
        }

        return dbPassword.equals(password);
    }
}
