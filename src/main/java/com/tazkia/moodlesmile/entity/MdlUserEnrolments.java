package com.tazkia.moodlesmile.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Data
@Entity
public class MdlUserEnrolments {

    @Id
    private BigInteger id;

    @NotNull
    private BigInteger status;

    @ManyToOne
    @JoinColumn(name = "enrolid",referencedColumnName = "id")
    private MdlEnrol enrolid;

    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "id")
    private MdlUser userid;

    @NotNull
    private BigInteger timestart;

    @NotNull
    private BigInteger timeend;

    @NotNull
    private BigInteger modifierid;

    @NotNull
    private BigInteger timeceated;

    @NotNull
    private BigInteger timemodified;

}
