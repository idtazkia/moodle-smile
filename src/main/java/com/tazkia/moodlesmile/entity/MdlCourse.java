package com.tazkia.moodlesmile.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.math.BigInteger;

@Data
@Entity
public class MdlCourse {

    @Id
    private BigInteger id;

    @NotNull
    private BigInteger category;

    @NotNull
    private BigInteger sortorder;

    @NotNull
    private String fullname;

    @NotNull
    private String shortname;

    @NotNull
    private String idnumber;

    @Column(columnDefinition = "LONGTEXT") @Lob
    private String summary;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer summaryformat;

    @NotNull
    private String format;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer showgrades;

    @NotNull
    @Column(columnDefinition = "MEDIUMINT")
    private Integer newsitems;

    @NotNull
    private BigInteger startdate;

    @NotNull
    private BigInteger enddate;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer relativedatesmode;

    @NotNull
    private BigInteger marker;

    @NotNull
    private BigInteger maxbytes;

    @NotNull
    @Column(columnDefinition = "SMALLINT")
    private Integer legacyfiles;

    @NotNull
    @Column(columnDefinition = "SMALLINT")
    private Integer showreports;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer visible;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer visibleold;

    @NotNull
    @Column(columnDefinition = "SMALLINT")
    private Integer groupmode;

    @NotNull
    @Column(columnDefinition = "")
    private Integer groupmodeforce;

    @NotNull
    private BigInteger defaultgroupingid;

    @NotNull
    private String lang;

    @NotNull
    private String calendartype;

    @NotNull
    private String theme;

    @NotNull
    private BigInteger timecreated;

    @NotNull
    private BigInteger timemodified;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer requested;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer enablecompletion;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer completionnotify;

    @NotNull
    private BigInteger cacherev;



}
