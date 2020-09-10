package com.tazkia.moodlesmile.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
public class MdlAttendanceLog {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name="sessionid", referencedColumnName="id")
    private MdlAttendanceSessions sessionid;

    @OneToOne
    @JoinColumn(name="studentid", referencedColumnName="id")
    private MdlUser studentid;

    @NotNull
    private BigInteger statusid;

    private String statusset;

    @NotNull
    private BigInteger timetaken;

    @OneToOne
    @JoinColumn(name="takenby", referencedColumnName="id")
    private MdlUser takenby;

    private String remarks;

    private String ipaddress;
}
