package com.tazkia.moodlesmile.controller;


import com.tazkia.moodlesmile.dao.MdlAttendanceDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceLogDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceSessionsDao;
import com.tazkia.moodlesmile.dao.MdlCourseDao;
import com.tazkia.moodlesmile.dto.CourseDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogIntDto;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import com.tazkia.moodlesmile.entity.MdlCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AttendanceApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceApiController.class);


    @Autowired
    private MdlAttendanceDao mdlAttendanceDao;

    @Autowired
    private MdlAttendanceLogDao mdlAttendanceLogDao;

    @Autowired
    private MdlAttendanceSessionsDao mdlAttendanceSessionsDao;

    @Autowired
    private MdlCourseDao mdlCourseDao;


    @GetMapping("/api/session")
    @ResponseBody
    public List<MdlAttendanceLogDto> attendanceLog(){

        List<MdlAttendanceLogIntDto> alog = mdlAttendanceLogDao.findJadwalSekarang();
        List<MdlAttendanceLogDto> adto = new ArrayList<>();

//    adto.addAll(alog);


        for (MdlAttendanceLogIntDto mdlAttendanceLog : alog){
        MdlAttendanceLogDto mdlAttendanceLogDto = new MdlAttendanceLogDto();
//        mdlAttendanceLogDto.setId(mdlAttendanceLog.getId());
//
//        mdlAttendanceLogDto.setStudentid(mdlAttendanceLog.getStudentid().getId());
//        mdlAttendanceLogDto.setIdnumbernim(mdlAttendanceLog.getStudentid().getIdnumber());
//        mdlAttendanceLogDto.setFirstname(mdlAttendanceLog.getStudentid().getFirstname());
//        mdlAttendanceLogDto.setTakenby(mdlAttendanceLog.getTakenby().getFirstname());
//        mdlAttendanceLogDto.setEmail(mdlAttendanceLog.getStudentid().getEmail());
//
//        mdlAttendanceLogDto.setSessionid(mdlAttendanceLog.getSessionid().getId());
//        mdlAttendanceLogDto.setSessdate(mdlAttendanceLog.getSessionid().getSessdate());
//
//        mdlAttendanceLogDto.setStatusid(mdlAttendanceLog.getStatusid().getId());
//        mdlAttendanceLogDto.setDescription(mdlAttendanceLog.getStatusid().getDescription());
//
//        mdlAttendanceLogDto.setAttendanceid(mdlAttendanceLog.getSessionid().getAttendanceid().getId());
//        mdlAttendanceLogDto.setGrade(mdlAttendanceLog.getSessionid().getAttendanceid().getGrade());
//
//
//        mdlAttendanceLogDto.setCourse(mdlAttendanceLog.getSessionid().getAttendanceid().getCourse().getId());
//        mdlAttendanceLogDto.setFullname(mdlAttendanceLog.getSessionid().getAttendanceid().getCourse().getFullname());
//        mdlAttendanceLogDto.setShortname(mdlAttendanceLog.getSessionid().getAttendanceid().getCourse().getShortname());
//        mdlAttendanceLogDto.setIdnumbercourse(mdlAttendanceLog.getSessionid().getAttendanceid().getCourse().getIdnumber());


        mdlAttendanceLogDto.setIdlog(mdlAttendanceLog.getId());
        mdlAttendanceLogDto.setIdTahunAkademik(mdlAttendanceLog.getIdTahunAkademik());
        mdlAttendanceLogDto.setIdJadwal(mdlAttendanceLog.getIdJadwal());
        mdlAttendanceLogDto.setWaktuMasuk(mdlAttendanceLog.getWaktuMasuk());
        mdlAttendanceLogDto.setWaktuSelesai(mdlAttendanceLog.getWaktuSelesai());
        mdlAttendanceLogDto.setStatusPresensi(mdlAttendanceLog.getStatusPresensi());
        mdlAttendanceLogDto.setStatus(mdlAttendanceLog.getStatus());
        mdlAttendanceLogDto.setIdDosen(mdlAttendanceLog.getIdDosen());


        adto.add(mdlAttendanceLogDto);
        }

        return adto;

    }

//    @PostMapping("")
//    public void insertCourse(@RequestBody CourseDto courseDto){
//        // insert ke tabel
//    }

}
