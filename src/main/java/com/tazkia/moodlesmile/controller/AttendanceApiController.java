package com.tazkia.moodlesmile.controller;


import com.tazkia.moodlesmile.dao.MdlAttendanceDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceLogDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceSessionsDao;
import com.tazkia.moodlesmile.dao.MdlCourseDao;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenIntDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogMahasiswaDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogMahasiswaIntDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/api/sessiondosen")
    @ResponseBody
    public List<MdlAttendanceLogDosenDto> attendanceLogDosen(){

        List<MdlAttendanceLogDosenIntDto> alog = mdlAttendanceLogDao.findJadwalSekarangDosen();
        List<MdlAttendanceLogDosenDto> adto = new ArrayList<>();

//    adto.addAll(alog);


        for (MdlAttendanceLogDosenIntDto mdlAttendanceLog : alog){
        MdlAttendanceLogDosenDto mdlAttendanceLogDosenDto = new MdlAttendanceLogDosenDto();

        mdlAttendanceLogDosenDto.setIdlog(mdlAttendanceLog.getId());
        mdlAttendanceLogDosenDto.setIdTahunAkademik(mdlAttendanceLog.getIdTahunAkademik());
        mdlAttendanceLogDosenDto.setIdJadwal(mdlAttendanceLog.getIdJadwal());
        mdlAttendanceLogDosenDto.setWaktuMasuk(mdlAttendanceLog.getWaktuMasuk());
        mdlAttendanceLogDosenDto.setWaktuSelesai(mdlAttendanceLog.getWaktuSelesai());
        mdlAttendanceLogDosenDto.setStatusPresensi(mdlAttendanceLog.getStatusPresensi());
        mdlAttendanceLogDosenDto.setStatus(mdlAttendanceLog.getStatus());
        mdlAttendanceLogDosenDto.setIdDosen(mdlAttendanceLog.getIdDosen());
        mdlAttendanceLogDosenDto.setBeritaAcara(mdlAttendanceLog.getBeritaAcara());


        adto.add(mdlAttendanceLogDosenDto);
        }

        return adto;

    }

    @GetMapping("/api/sessionmahasiswa")
    @ResponseBody
    public List<MdlAttendanceLogMahasiswaDto> attendanceLogMahasiswa(){

        List<MdlAttendanceLogMahasiswaIntDto> alog = mdlAttendanceLogDao.findJadwalSekarangMahasiswa();
        List<MdlAttendanceLogMahasiswaDto> adto = new ArrayList<>();

//    adto.addAll(alog);


        for (MdlAttendanceLogMahasiswaIntDto mdlAttendanceLog : alog){
            MdlAttendanceLogMahasiswaDto mdlAttendanceLogMahasiswaDto = new MdlAttendanceLogMahasiswaDto();

            mdlAttendanceLogMahasiswaDto.setIdlog(mdlAttendanceLog.getId());
            mdlAttendanceLogMahasiswaDto.setIdTahunAkademik(mdlAttendanceLog.getIdTahunAkademik());
            mdlAttendanceLogMahasiswaDto.setIdJadwal(mdlAttendanceLog.getIdJadwal());
            mdlAttendanceLogMahasiswaDto.setWaktuMasuk(mdlAttendanceLog.getWaktuMasuk());
            mdlAttendanceLogMahasiswaDto.setWaktuSelesai(mdlAttendanceLog.getWaktuSelesai());
            mdlAttendanceLogMahasiswaDto.setStatusPresensi(mdlAttendanceLog.getStatusPresensi());
            mdlAttendanceLogMahasiswaDto.setStatus(mdlAttendanceLog.getStatus());
            mdlAttendanceLogMahasiswaDto.setMahasiswa(mdlAttendanceLog.getMahasiswa());



            adto.add(mdlAttendanceLogMahasiswaDto);
        }

        return adto;

    }

    @GetMapping("/api/sessionmahasiswa2")
    @ResponseBody
    public List<MdlAttendanceLogMahasiswaDto> attendanceLogMahasiswa2(@RequestParam String id){

        List<MdlAttendanceLogMahasiswaIntDto> alog = mdlAttendanceLogDao.findJadwalSekarangMahasiswa2(id);
        List<MdlAttendanceLogMahasiswaDto> adto = new ArrayList<>();

//    adto.addAll(alog);


        for (MdlAttendanceLogMahasiswaIntDto mdlAttendanceLog : alog){
            MdlAttendanceLogMahasiswaDto mdlAttendanceLogMahasiswaDto = new MdlAttendanceLogMahasiswaDto();

            mdlAttendanceLogMahasiswaDto.setIdlog(mdlAttendanceLog.getId());
            mdlAttendanceLogMahasiswaDto.setIdTahunAkademik(mdlAttendanceLog.getIdTahunAkademik());
            mdlAttendanceLogMahasiswaDto.setIdJadwal(mdlAttendanceLog.getIdJadwal());
            mdlAttendanceLogMahasiswaDto.setWaktuMasuk(mdlAttendanceLog.getWaktuMasuk());
            mdlAttendanceLogMahasiswaDto.setWaktuSelesai(mdlAttendanceLog.getWaktuSelesai());
            mdlAttendanceLogMahasiswaDto.setStatusPresensi(mdlAttendanceLog.getStatusPresensi());
            mdlAttendanceLogMahasiswaDto.setStatus(mdlAttendanceLog.getStatus());
            mdlAttendanceLogMahasiswaDto.setMahasiswa(mdlAttendanceLog.getMahasiswa());



            adto.add(mdlAttendanceLogMahasiswaDto);
        }

        return adto;

    }

//    @PostMapping("")
//    public void insertCourse(@RequestBody CourseDto courseDto){
//        // insert ke tabel
//    }

}
