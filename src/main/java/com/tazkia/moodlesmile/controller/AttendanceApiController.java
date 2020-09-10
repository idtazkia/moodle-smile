package com.tazkia.moodlesmile.controller;


import com.tazkia.moodlesmile.dao.MdlAttendanceDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceLogDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceSessionsDao;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogDto;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
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


    @GetMapping("/api/attendancelog")
    @ResponseBody
    public List<MdlAttendanceLogDto> attendanceLog(@RequestParam BigInteger sessionid){

    List<MdlAttendanceLog> alog =mdlAttendanceLogDao.findBySessionid(mdlAttendanceSessionsDao.findById(sessionid).get());
    List<MdlAttendanceLogDto> adto = new ArrayList<>();


        for (MdlAttendanceLog mdlAttendanceLog : alog){
        MdlAttendanceLogDto mdlAttendanceLogDto = new MdlAttendanceLogDto();
        mdlAttendanceLogDto.setId(mdlAttendanceLog.getId());
        mdlAttendanceLogDto.setSessionid(mdlAttendanceLog.getSessionid());
        mdlAttendanceLogDto.setStudentid(mdlAttendanceLog.getStudentid());
        mdlAttendanceLogDto.setTakenby(mdlAttendanceLog.getTakenby());
        adto.add(mdlAttendanceLogDto);
        }

        return adto;

    }



}
