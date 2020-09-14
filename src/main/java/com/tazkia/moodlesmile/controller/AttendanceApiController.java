package com.tazkia.moodlesmile.controller;


import com.tazkia.moodlesmile.dao.MdlAttendanceDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceLogDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceSessionsDao;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogDto;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AttendanceApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceApiController.class);


    @Autowired
    private MdlAttendanceDao mdlAttendanceDao;

    @Autowired
    private MdlAttendanceLogDao mdlAttendanceLogDao;

    @Autowired
    private MdlAttendanceSessionsDao mdlAttendanceSessionsDao;


    @GetMapping("/api/session")
    @ResponseBody
    public List<MdlAttendanceLogDto> attendanceLog(@RequestParam BigInteger sessionid){

    List<MdlAttendanceLog> alog = mdlAttendanceLogDao.findBySessionid(mdlAttendanceSessionsDao.findById(sessionid).get());
    List<MdlAttendanceLogDto> adto = new ArrayList<>();


        for (MdlAttendanceLog mdlAttendanceLog : alog){
        MdlAttendanceLogDto mdlAttendanceLogDto = new MdlAttendanceLogDto();
        mdlAttendanceLogDto.setId(mdlAttendanceLog.getId());

        mdlAttendanceLogDto.setStudentid(mdlAttendanceLog.getStudentid().getId());
        mdlAttendanceLogDto.setFirstname(mdlAttendanceLog.getStudentid().getFirstname());
        mdlAttendanceLogDto.setTakenby(mdlAttendanceLog.getTakenby().getFirstname());

        mdlAttendanceLogDto.setSessionid(mdlAttendanceLog.getSessionid().getId());
        mdlAttendanceLogDto.setSessdate(mdlAttendanceLog.getSessionid().getSessdate());

        mdlAttendanceLogDto.setStatusid(mdlAttendanceLog.getStatusid().getId());
        mdlAttendanceLogDto.setDescription(mdlAttendanceLog.getStatusid().getDescription());

        mdlAttendanceLogDto.setAttendanceid(mdlAttendanceLog.getSessionid().getAttendanceid().getId());
        mdlAttendanceLogDto.setGrade(mdlAttendanceLog.getSessionid().getAttendanceid().getGrade());


        mdlAttendanceLogDto.setCourse(mdlAttendanceLog.getSessionid().getAttendanceid().getCourse().getId());
        mdlAttendanceLogDto.setFullname(mdlAttendanceLog.getSessionid().getAttendanceid().getCourse().getFullname());

        adto.add(mdlAttendanceLogDto);
        }

        return adto;

    }



}
