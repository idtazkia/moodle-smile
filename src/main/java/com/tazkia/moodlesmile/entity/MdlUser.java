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
public class MdlUser {

    @Id
    private BigInteger id;

    @NotNull
    private String auth;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer confirmed;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer policyagreed;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer deleted;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer suspended;

    @NotNull
    private BigInteger mnethostid;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String idnumber;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String email;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer emailstop;

    @NotNull
    private String icq;

    @NotNull
    private String skype;

    @NotNull
    private String yahoo;

    @NotNull
    private String aim;

    @NotNull
    private String msn;

    @NotNull
    private String phone1;

    @NotNull
    private String phone2;

    @NotNull
    private String institution;

    @NotNull
    private String department;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String lang;

    @NotNull
    private String calendartype;

    @NotNull
    private String theme;

    @NotNull
    private String timezone;

    @NotNull
    private BigInteger firstaccess;

    @NotNull
    private BigInteger lastaccess;

    @NotNull
    private BigInteger lastlogin;

    @NotNull
    private BigInteger currentlogin;

    @NotNull
    private String lastip;

    @NotNull
    private String secret;

    @NotNull
    private BigInteger picture;

    @NotNull
    private String url;

    @Column(columnDefinition = "LONGTEXT") @Lob
    private String description;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer descriptionformat;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer mailformat;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer maildigest;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer maildisplay;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer autosubscribe;

    @NotNull
    @Column(columnDefinition = "TINYINT")
    private Integer trackforums;

    @NotNull
    private BigInteger timecreated;

    @NotNull
    private BigInteger timemodified;

    @NotNull
    private BigInteger trustbitmask;

    private String imagealt;

    private String lastnamephonetic;

    private String firstnamephonetic;

    private String middlename;

    private String alternatename;

    private String moodlenetprofile;





}
