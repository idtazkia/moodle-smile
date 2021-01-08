package com.tazkia.moodlesmile.controller;


import com.tazkia.moodlesmile.dao.MdlAttendanceDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceLogDao;
import com.tazkia.moodlesmile.dao.MdlAttendanceSessionsDao;
import com.tazkia.moodlesmile.dao.MdlCourseDao;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenIntDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogMahasiswaDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogMahasiswaIntDto;
import com.tazkia.moodlesmile.entity.MdlAttendance;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AttendanceApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceApiController.class);

//    WebClient webClient1 = WebClient.builder()
//            .baseUrl("http://localhost:8080")
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .build();
//
//    public MdlAttendanceLog changeStatus(@RequestParam String id) {
//        return webClient1.get()
//                .uri("/api/changestatus?="+id)
//                .retrieve().bodyToMono(MdlAttendanceLog.class)
//                .block();
//    }


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
    public List<MdlAttendanceLogDosenDto> attendanceLogDosen(@RequestParam String tanggalImport){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(tanggalImport, formatter);
        List<MdlAttendanceLogDosenIntDto> alog = mdlAttendanceLogDao.findJadwalSekarangDosen(localDate);
        List<MdlAttendanceLogDosenDto> adto = new ArrayList<>();

//    adto.addAll(alog);


        for (MdlAttendanceLogDosenIntDto mdlAttendanceLog : alog){
        MdlAttendanceLogDosenDto mdlAttendanceLogDosenDto = new MdlAttendanceLogDosenDto();

        mdlAttendanceLogDosenDto.setIdSession(mdlAttendanceLog.getId());
        mdlAttendanceLogDosenDto.setIdTahunAkademik(mdlAttendanceLog.getIdTahunAkademik());
        mdlAttendanceLogDosenDto.setIdJadwal(mdlAttendanceLog.getIdJadwal());
        mdlAttendanceLogDosenDto.setWaktuMasuk(mdlAttendanceLog.getWaktuMasuk());
        mdlAttendanceLogDosenDto.setWaktuSelesai(mdlAttendanceLog.getWaktuSelesai());
        mdlAttendanceLogDosenDto.setStatusPresensi(mdlAttendanceLog.getStatusPresensi());
        mdlAttendanceLogDosenDto.setStatus(mdlAttendanceLog.getStatus());
        mdlAttendanceLogDosenDto.setIdDosen(mdlAttendanceLog.getIdDosen());
        mdlAttendanceLogDosenDto.setBeritaAcara(mdlAttendanceLog.getBeritaAcara());
        mdlAttendanceLogDosenDto.setIdLog(mdlAttendanceLog.getIdLog());



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

            mdlAttendanceLogMahasiswaDto.setIdSession(mdlAttendanceLog.getId());
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
    @Transactional
    public List<MdlAttendanceLogMahasiswaDto> attendanceLogMahasiswa2(@RequestParam String id){

        List<MdlAttendanceLogMahasiswaIntDto> alog = mdlAttendanceLogDao.findJadwalSekarangMahasiswa2(id);
        List<MdlAttendanceLogMahasiswaDto> adto = new ArrayList<>();

//    adto.addAll(alog);


        for (MdlAttendanceLogMahasiswaIntDto mdlAttendanceLog : alog){
            MdlAttendanceLogMahasiswaDto mdlAttendanceLogMahasiswaDto = new MdlAttendanceLogMahasiswaDto();


            mdlAttendanceLogMahasiswaDto.setIdSession(mdlAttendanceLog.getId());
            mdlAttendanceLogMahasiswaDto.setIdTahunAkademik(mdlAttendanceLog.getIdTahunAkademik());
            mdlAttendanceLogMahasiswaDto.setIdJadwal(mdlAttendanceLog.getIdJadwal());
            mdlAttendanceLogMahasiswaDto.setWaktuMasuk(mdlAttendanceLog.getWaktuMasuk());
            mdlAttendanceLogMahasiswaDto.setWaktuSelesai(mdlAttendanceLog.getWaktuSelesai());
            mdlAttendanceLogMahasiswaDto.setStatusPresensi(mdlAttendanceLog.getStatusPresensi());
            mdlAttendanceLogMahasiswaDto.setStatus(mdlAttendanceLog.getStatus());
            mdlAttendanceLogMahasiswaDto.setMahasiswa(mdlAttendanceLog.getMahasiswa());

            adto.add(mdlAttendanceLogMahasiswaDto);

        }



        mdlAttendanceLogDao.updateMdlLog(new BigInteger(id));
        return adto;

    }

//    @GetMapping("/api/updateattendence")
//    @ResponseBody
//    @Transactional
//    public String updateAttendanceLog(@RequestParam String id){
//            mdlAttendanceLogDao.updateMdlLog(new BigInteger(id));
//
//        System.out.println("ubah");
//        return "sukses";
//
//    }

//    @GetMapping("/api/changestatus")
//    public void changeImportStatus2(@RequestParam String id){
//        MdlAttendanceLog mdlAttendanceLog = changeStatus(id);
//        mdlAttendanceLog.setStatusimport("SUDAH");
//        mdlAttendanceLogDao.save(mdlAttendanceLog);
//
//
//    }



//    @PostMapping("")
//    public void insertImportStatus(){
//
//
//    }

//    @PostMapping("")
//    public void insertCourse(@RequestBody CourseDto courseDto){
//        // insert ke tabel
//    }

}
