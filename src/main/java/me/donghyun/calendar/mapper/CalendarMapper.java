package me.donghyun.calendar.mapper;

import me.donghyun.calendar.dto.CalendarResult;
import me.donghyun.calendar.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CalendarMapper {

    List<CalendarResult> findAll();

    CalendarResult findById(Long id);

    Member login(Map<String, String> param);

    int insertMember(Map<String, String> param);

    List<CalendarResult> scheduleDataSelect(Member member);

    void insertSchedule(Map<String, String> param);

    void deleteSchedule(Map<String, String> param);
}
