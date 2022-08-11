package me.donghyun.calendar.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.donghyun.calendar.dto.CalendarResult;
import me.donghyun.calendar.dto.Member;
import me.donghyun.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/calendars")
@CrossOrigin("http://localhost:3000")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping
    public List<CalendarResult> findAll() {
        log.debug("CalendarController :: findAll");
        return calendarService.findAll();
    }

    @GetMapping("{id}")
    public CalendarResult findById(@PathVariable Long id) {
        return calendarService.findById(id);
    }

    @PostMapping("/login")
    public long login(@RequestBody Map<String,String> param){
        return calendarService.login(param);
    }

    @PostMapping("/selectMonthSchedule")
    public List<CalendarResult> selectScheduleDate(@RequestBody Map<String,String> param){

        return calendarService.scheduleDateSelect(param);
    }

    @PostMapping("/insert-schedule")
    public List<CalendarResult> insertSchedule(@RequestBody Map<String,String> param) {
        calendarService.insertSchedule(param);
        param.put("selectMonth",param.get("addDate").substring(0,6)+"%");
        return selectScheduleDate(param);
    }
}
