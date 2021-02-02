package com.tazkia.moodlesmile.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
public class MdlGradeGrades {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name="itemid", referencedColumnName="id")
    private MdlGradeItems itemid;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName="id")
    private MdlUser userid;

    private BigDecimal rawgrade;

    @NotNull
    private BigDecimal rawgrademax;

    @NotNull
    private BigDecimal rawgrademin;

    private BigInteger rawscaleid;

    private BigInteger usermodiefied;

    private BigDecimal finalgrade;

    @NotNull
    private BigInteger hidden;

    @NotNull
    private BigInteger locked;

    @NotNull
    private BigInteger locktime;

    @NotNull
    private BigInteger exported;

    @NotNull
    private BigInteger overriden;

    @NotNull
    private BigInteger excluded;

    @Lob
    private String feedback;

    @NotNull
    private BigInteger feedbackformat;

    @Lob
    private String information;

    @NotNull
    private BigInteger informationformat;

    private BigInteger timecreated;

    private BigInteger timemodified;

    @NotNull
    private String aggregationstatus;

    private BigInteger aggregationweight;


}
