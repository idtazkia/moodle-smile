package com.tazkia.moodlesmile.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
public class MdlAttendanceSessions {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name="attendanceid", referencedColumnName="id")
    private MdlAttendance attendanceid;

    @NotNull
    private BigInteger groupid;

    @NotNull
    private BigInteger sessdate;

    @NotNull
    private BigInteger duration;

    private BigInteger lasttaken;

    @NotNull
    private BigInteger lasttakenby;

    private BigInteger timemodified;

    @NotNull
    @Column(columnDefinition = "LONGTEXT") @Lob
    private String description;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer descriptionformat;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer studentscanmark;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer autoassignstatus;

    private String studentpassword;

    private String subnet;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer automark;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer automarkcompleted;

    @NotNull
    @Column(columnDefinition = "MEDIUMINT")
    private Integer statusset;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer absenteereport;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer preventsharedip;

    private BigInteger preventsharediptime;

    @NotNull
    private BigInteger caleventid;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer calendarevent;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer includeqrcode;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer rotateqrcode;

    private String rotateqrcodesecret;



}
