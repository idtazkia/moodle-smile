package com.tazkia.moodlesmile.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
public class MdlGradeItems {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name="courseid", referencedColumnName="id")
    private MdlCourse courseid;

    @ManyToOne
    @JoinColumn(name="categoryid", referencedColumnName="id")
    private MdlGradeCategories categoryid;

    private String itemname;

    @NotNull
    private String itemtype;

    private String itemmodule;

    private BigInteger iteminstance;

    private BigInteger itemnumber;

    @Lob
    private String iteminfo;

    private String idnumber;

    @NotNull
    @Column(columnDefinition = "SMALLINT")
    private Integer gradetype;

    @NotNull
    private BigDecimal grademax;

    @NotNull
    private BigDecimal grademin;

    private BigInteger scaleid;

    private BigInteger outcomeid;

    @NotNull
    private BigDecimal gradepass;

    @NotNull
    private BigDecimal multfactor;

    @NotNull
    private BigDecimal plusfactor;

    @NotNull
    private BigDecimal aggregationcoef;

    @NotNull
    private BigDecimal aggregationcoef2;

    @NotNull
    private BigInteger sortorder;

    @NotNull
    private BigInteger display;

    @Column(columnDefinition = "SMALLINT")
    private Integer decimals;

    @NotNull
    private BigInteger hidden;

    @NotNull
    private BigInteger locked;

    @NotNull
    private BigInteger locktime;

    @NotNull
    private BigInteger needsupdate;

    @Column(columnDefinition = "SMALLINT")
    private Integer weightoverride;

    private BigInteger timecreated;

    private BigInteger timemodified;










}
