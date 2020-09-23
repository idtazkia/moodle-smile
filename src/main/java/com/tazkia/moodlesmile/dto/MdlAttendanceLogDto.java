package com.tazkia.moodlesmile.dto;


import com.sun.istack.NotNull;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import com.tazkia.moodlesmile.entity.MdlUser;
import lombok.Data;

import java.math.BigInteger;

@Data
public class MdlAttendanceLogDto {

    //log
    private BigInteger id;
    private String statusset;
    private BigInteger timetaken;
    private String remarks;
    private String ipaddress;



    //user
    private BigInteger studentid;
    private String firstname;
    private String idnumbernim;
    private String email;
    private String takenby;

    //session
    private BigInteger sessionid;
    private BigInteger sessdate;

    //status
    private BigInteger statusid;
    private String description;

    //attendance
    private BigInteger attendanceid;
    private String name;
    private BigInteger grade;

    //course
    private BigInteger course;
    private String fullname;
    private String shortname;
    private String idnumbercourse;

}
