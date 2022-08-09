package me.donghyun.calendar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
public class Member {

    private Long memberNo;
    private String ID;
    private String PW;

    private String selectMonth;


}
