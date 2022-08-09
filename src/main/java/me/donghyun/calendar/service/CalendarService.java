package me.donghyun.calendar.service;

import lombok.extern.slf4j.Slf4j;
import me.donghyun.calendar.dto.CalendarResult;
import me.donghyun.calendar.dto.Member;
import me.donghyun.calendar.mapper.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CalendarService {

    @Autowired
    private CalendarMapper calendarMapper;

    public List<CalendarResult> findAll() {
        return calendarMapper.findAll();
    }

    public CalendarResult findById(Long id) {
        return calendarMapper.findById(id);
    }



    public Member login(Map<String,String> param){

        Member member = calendarMapper.login(param);

        if(member == null) {
            insertMember(param);
            member = calendarMapper.login(param);
        }

        return member;
    }

    public List<CalendarResult> scheduleDateSelect(Map<String,String> param){

        long memberNo = Long.parseLong(param.get("memberNo"));

        Member member = new Member();
        member.setMemberNo(memberNo);
        member.setSelectMonth(param.get("selectMonth"));

        return calendarMapper.scheduleDataSelect(member);
    }

    public int insertMember(Map<String,String> param){
        return calendarMapper.insertMember(param);
    }

}
