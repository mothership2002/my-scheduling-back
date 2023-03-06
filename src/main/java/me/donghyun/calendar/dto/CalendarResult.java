package me.donghyun.calendar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarResult {

    private Long scheduleNo;
    private Long memberNo;

    private String insertDate;
    private String contents;

    private String scheduleDate;

}
