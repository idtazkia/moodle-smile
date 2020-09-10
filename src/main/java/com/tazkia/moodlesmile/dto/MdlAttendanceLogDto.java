package com.tazkia.moodlesmile.dto;


import com.sun.istack.NotNull;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import com.tazkia.moodlesmile.entity.MdlUser;
import lombok.Data;

import java.math.BigInteger;

@Data
public class MdlAttendanceLogDto {

    private BigInteger id;

    private MdlAttendanceSessions sessionid;

    private MdlUser studentid;

    private BigInteger statusid;

    private String statusset;

    private BigInteger timetaken;

    private MdlUser takenby;

    private String remarks;

    private String ipaddress;

}
