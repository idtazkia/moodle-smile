package com.tazkia.moodlesmile.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
public class MdlGradeCategories {

    @Id
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name="courseid", referencedColumnName="id")
    private MdlCourse courseid;

    private BigInteger parent;

    @NotNull
    private BigInteger depth;

    private String path;

    @NotNull
    private String fullname;

    @NotNull
    private BigInteger aggregation;

    @NotNull
    private BigInteger keephigh;

    @NotNull
    private BigInteger droplow;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer aggregatonlygraded;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer aggregatoutcome;

    @NotNull
    private BigInteger timecreated;

    @NotNull
    private BigInteger timemodified;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer hidden;


}
