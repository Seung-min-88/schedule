package com.example.scdmg.repository;

import com.example.scdmg.dto.ScheduleResponseDto;
import com.example.scdmg.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("scdTable").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", schedule.getId());
        parameters.put("name", schedule.getName());
        parameters.put("todo", schedule.getTodo());
        parameters.put("createTime", schedule.getCreateTime());
        parameters.put("updateTime", schedule.getUpdateTime());
        parameters.put("password", schedule.getPassword());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new ScheduleResponseDto(key.longValue(), schedule.getName(), schedule.getTodo());
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return jdbcTemplate.query("select id, name, todo from scdTable", scheduleRowMapper());
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return (rs, rowNum)-> new ScheduleResponseDto(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("todo")
        );
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        List<Schedule> result = jdbcTemplate.query("select * from scdTable where id = ?", scheduleRowMapperV2(), id);

        return  result.stream().findAny();
    }

    @Override
    public void deleteSchedule(Long id) {
        int deletedRows = jdbcTemplate.update("DELETE FROM scdTable WHERE id = ?", id);
        if (deletedRows == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
    }

    private RowMapper<Schedule> scheduleRowMapperV2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("todo"),
                        rs.getString("password")
                );
            }

        };
    }

    @Override
    public int updateSchedule(Long id, String name, String todo){
        return jdbcTemplate.update("update scdTable set name = ?, todo = ? where id = ?", name, todo, id);
    }

    @Override
    public Schedule findByIdOrElseThrow(Long id) {
        List<Schedule> result = jdbcTemplate.query("select * from scdTable where id = ?", scheduleRowMapperV2(), id);
        return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dose not exist id = " + id));
    }
}
