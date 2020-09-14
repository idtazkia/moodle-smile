package com.tazkia.moodlesmile.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
public class MdlAttendanceStatuses {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "attendanceid",referencedColumnName = "id")
    private MdlAttendance attendanceid;

    @NotNull
    private String acronym;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal grade;

    private BigInteger studentavailability;

    @Column(columnDefinition = "TINYINT")
    private Integer setunmarked;

    @Column(columnDefinition = "TINYINT")
    private Integer visible;

    @Column(columnDefinition = "TINYINT")
    private Integer deleted;

    @Column(columnDefinition = "MEDIUMINT")
    private Integer setnumber;





}
