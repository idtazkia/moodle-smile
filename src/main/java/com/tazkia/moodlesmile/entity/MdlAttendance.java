package com.tazkia.moodlesmile.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
public class MdlAttendance {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name="course", referencedColumnName="id")
    private MdlCourse course;

    private String name;

    @NotNull
    private BigInteger grade;

    @NotNull
    private BigInteger timemodified;

    @Column(columnDefinition = "LONGTEXT") @Lob
    private String intro;

    @NotNull
    @Column(columnDefinition = "SMALLINT")
    private Integer introformat;

    private String subnet;

    @NotNull
    private String sessiondetailspos;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer showsessiondetails;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer showextrauserdetails;







}
