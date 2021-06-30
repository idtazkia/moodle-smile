package com.tazkia.moodlesmile.controller;

import com.tazkia.moodlesmile.dao.MdlGradeItemsDao;
import com.tazkia.moodlesmile.dto.*;
import com.tazkia.moodlesmile.entity.MdlGradeItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AssessmentApiController {

    @Autowired
    private MdlGradeItemsDao mdlGradeItemsDao;

    //tugas
    @GetMapping("/api/bobottugas")
    @ResponseBody
    public List<MdlGradeItemsDto> bobotTugas(String tahunAkademik){

        List<MdlGradeItemsIntDto> tugas1 = mdlGradeItemsDao.getItemTugas(tahunAkademik);
        List<MdlGradeItemsDto> tugas2 = new ArrayList<>();

        for (MdlGradeItemsIntDto mdlGradeItemsIntDto : tugas1){
            MdlGradeItemsDto mdlGradeItemsDto = new MdlGradeItemsDto();

            mdlGradeItemsDto.setId(mdlGradeItemsIntDto.getId());
            mdlGradeItemsDto.setIdJadwal(mdlGradeItemsIntDto.getIdJadwal());
            mdlGradeItemsDto.setNamaTugas(mdlGradeItemsIntDto.getNamaTugas());
            mdlGradeItemsDto.setBobot(mdlGradeItemsIntDto.getBobot());
            mdlGradeItemsDto.setStatusA(mdlGradeItemsIntDto.getStatusA());
            mdlGradeItemsDto.setPertemuan(mdlGradeItemsIntDto.getPertemuan());
            mdlGradeItemsDto.setTimeCreated(mdlGradeItemsIntDto.getTimeCreated());
            mdlGradeItemsDto.setTimeModified(mdlGradeItemsIntDto.getTimeModified());

            tugas2.add(mdlGradeItemsDto);
        }

        return tugas2;

    }

    @GetMapping("/api/bobotaslitugas")
    @ResponseBody
    public List<MdlGradeItemsDto> bobotAsliTugas(String tahunAkademik){

        List<MdlGradeItemsIntDto> tugasA1 = mdlGradeItemsDao.getItemAsliTugas(tahunAkademik);
        List<MdlGradeItemsDto> tugasA2 = new ArrayList<>();

        for (MdlGradeItemsIntDto mdlGradeItemsIntDto : tugasA1){
            MdlGradeItemsDto mdlGradeItemsDto = new MdlGradeItemsDto();

            mdlGradeItemsDto.setId(mdlGradeItemsIntDto.getId());
            mdlGradeItemsDto.setIdJadwal(mdlGradeItemsIntDto.getIdJadwal());
            mdlGradeItemsDto.setNamaTugas(mdlGradeItemsIntDto.getNamaTugas());
            mdlGradeItemsDto.setBobot(mdlGradeItemsIntDto.getBobot());
            mdlGradeItemsDto.setStatusA(mdlGradeItemsIntDto.getStatusA());
            mdlGradeItemsDto.setPertemuan(mdlGradeItemsIntDto.getPertemuan());
            mdlGradeItemsDto.setTimeCreated(mdlGradeItemsIntDto.getTimeCreated());
            mdlGradeItemsDto.setTimeModified(mdlGradeItemsIntDto.getTimeModified());

            tugasA2.add(mdlGradeItemsDto);
        }

        return tugasA2;

    }

    @GetMapping("/api/bobotuts")
    @ResponseBody
    public List<MdlGradeItemsDto> bobotUts(String tahunAkademik){

        List<MdlGradeItemsIntDto> uts1 = mdlGradeItemsDao.getItemUts(tahunAkademik);
        List<MdlGradeItemsDto> uts2 = new ArrayList<>();

        for (MdlGradeItemsIntDto mdlGradeItemsIntDto : uts1){
            MdlGradeItemsDto mdlGradeItemsDto = new MdlGradeItemsDto();

            mdlGradeItemsDto.setId(mdlGradeItemsIntDto.getId());
            mdlGradeItemsDto.setIdJadwal(mdlGradeItemsIntDto.getIdJadwal());
            mdlGradeItemsDto.setNamaTugas(mdlGradeItemsIntDto.getNamaTugas());
            mdlGradeItemsDto.setBobot(mdlGradeItemsIntDto.getBobot());
            mdlGradeItemsDto.setStatusA(mdlGradeItemsIntDto.getStatusA());
            mdlGradeItemsDto.setPertemuan(mdlGradeItemsIntDto.getPertemuan());
            mdlGradeItemsDto.setTimeCreated(mdlGradeItemsIntDto.getTimeCreated());
            mdlGradeItemsDto.setTimeModified(mdlGradeItemsIntDto.getTimeModified());

            uts2.add(mdlGradeItemsDto);
        }

        return uts2;

    }

    @GetMapping("/api/bobotuas")
    @ResponseBody
    public List<MdlGradeItemsDto> bobotUas(String tahunAkademik){

        List<MdlGradeItemsIntDto> uas1 = mdlGradeItemsDao.getItemUas(tahunAkademik);
        List<MdlGradeItemsDto> uas2 = new ArrayList<>();

        for (MdlGradeItemsIntDto mdlGradeItemsIntDto : uas1){
            MdlGradeItemsDto mdlGradeItemsDto = new MdlGradeItemsDto();

            mdlGradeItemsDto.setId(mdlGradeItemsIntDto.getId());
            mdlGradeItemsDto.setIdJadwal(mdlGradeItemsIntDto.getIdJadwal());
            mdlGradeItemsDto.setNamaTugas(mdlGradeItemsIntDto.getNamaTugas());
            mdlGradeItemsDto.setBobot(mdlGradeItemsIntDto.getBobot());
            mdlGradeItemsDto.setStatusA(mdlGradeItemsIntDto.getStatusA());
            mdlGradeItemsDto.setPertemuan(mdlGradeItemsIntDto.getPertemuan());
            mdlGradeItemsDto.setTimeCreated(mdlGradeItemsIntDto.getTimeCreated());
            mdlGradeItemsDto.setTimeModified(mdlGradeItemsIntDto.getTimeModified());

            uas2.add(mdlGradeItemsDto);
        }

        return uas2;

    }

    @GetMapping("/api/nilaitugas")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaitugas(){

        List<MdlGradeGradesIntDto> nilaitugas1 = mdlGradeItemsDao.getGradesTugas();
        List<MdlGradeGradesDto> nilaitugas2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaitugas1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaitugas2.add(mdlGradeGradesDto);
        }

        return nilaitugas2;

    }

    // perhitungan semua tugas
    @GetMapping("/api/nilaicounttugas")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaiCountTugas(){

        List<MdlGradeGradesIntDto> nilaicounttugas1 = mdlGradeItemsDao.getGradesCountNilaiTugas();
        List<MdlGradeGradesDto> nilaicounttugas2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaicounttugas1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaicounttugas2.add(mdlGradeGradesDto);
        }

        return nilaicounttugas2;

    }

    @GetMapping("/api/nilaiuts")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaiuts(){

        List<MdlGradeGradesIntDto> nilaiuts1 = mdlGradeItemsDao.getGradesUts();
        List<MdlGradeGradesDto> nilaiuts2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaiuts1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaiuts2.add(mdlGradeGradesDto);
        }

        return nilaiuts2;

    }

    @GetMapping("/api/nilaiuas")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaiuas(){

        List<MdlGradeGradesIntDto> nilaiuas1 = mdlGradeItemsDao.getGradesUas();
        List<MdlGradeGradesDto> nilaiuas2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaiuas1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaiuas2.add(mdlGradeGradesDto);
        }

        return nilaiuas2;

    }


    @GetMapping("/api/nilaitugas2")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaitugas2(){

        List<MdlGradeGradesIntDto> nilaitugas1 = mdlGradeItemsDao.getGradesTugas2();
        List<MdlGradeGradesDto> nilaitugas2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaitugas1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdNumber(mdlGradeGradesIntDto.getIdNumber());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setFinalgrade(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getNilai());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaitugas2.add(mdlGradeGradesDto);
        }

        return nilaitugas2;
    }



    @GetMapping("/api/nilaiuts2")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaiuts2(){

        List<MdlGradeGradesIntDto> nilaiuts1 = mdlGradeItemsDao.getGradesUts2();
        List<MdlGradeGradesDto> nilaiuts2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaiuts1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdNumber(mdlGradeGradesIntDto.getIdNumber());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setFinalgrade(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getNilai());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaiuts2.add(mdlGradeGradesDto);
        }

        return nilaiuts2;

    }

    @GetMapping("/api/nilaiuas2")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaiuas2(){

        List<MdlGradeGradesIntDto> nilaiuas1 = mdlGradeItemsDao.getGradesUas2();
        List<MdlGradeGradesDto> nilaiuas2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaiuas1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdNumber(mdlGradeGradesIntDto.getIdNumber());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setFinalgrade(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getNilai());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaiuas2.add(mdlGradeGradesDto);
        }

        return nilaiuas2;

    }

    @GetMapping("/api/nilaitugaspermhs")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaitugaspermhs(){

        List<MdlGradeGradesIntDto> nilaitugaspermhs1 = mdlGradeItemsDao.getGradesTugasPerMhs();
        List<MdlGradeGradesDto> nilaitugaspermhs2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaitugaspermhs1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdNumber(mdlGradeGradesIntDto.getIdNumber());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setFinalgrade(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getNilai());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaitugaspermhs2.add(mdlGradeGradesDto);
        }

        return nilaitugaspermhs2;

    }

    @GetMapping("/api/nilaitugasperuts")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaitugasperuts(){

        List<MdlGradeGradesIntDto> nilaitugasperuts1 = mdlGradeItemsDao.getGradesUtsPerMhs();
        List<MdlGradeGradesDto> nilaitugasperuts2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaitugasperuts1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdNumber(mdlGradeGradesIntDto.getIdNumber());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setFinalgrade(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getNilai());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaitugasperuts2.add(mdlGradeGradesDto);
        }

        return nilaitugasperuts2;

    }

    @GetMapping("/api/nilaitugasperuas")
    @ResponseBody
    public List<MdlGradeGradesDto> nilaitugasperuas(){

        List<MdlGradeGradesIntDto> nilaitugasperuas1 = mdlGradeItemsDao.getGradesUasPerMhs();
        List<MdlGradeGradesDto> nilaitugasperuas2 = new ArrayList<>();

        for (MdlGradeGradesIntDto mdlGradeGradesIntDto : nilaitugasperuas1){
            MdlGradeGradesDto mdlGradeGradesDto = new MdlGradeGradesDto();

            mdlGradeGradesDto.setId(mdlGradeGradesIntDto.getId());
            mdlGradeGradesDto.setIdNumber(mdlGradeGradesIntDto.getIdNumber());
            mdlGradeGradesDto.setIdJadwal(mdlGradeGradesIntDto.getIdJadwal());
            mdlGradeGradesDto.setMahasiswa(mdlGradeGradesIntDto.getMahasiswa());
            mdlGradeGradesDto.setIdBobotTugas(mdlGradeGradesIntDto.getIdBobotTugas());
            mdlGradeGradesDto.setFinalgrade(mdlGradeGradesIntDto.getFinalgrade());
            mdlGradeGradesDto.setStatus(mdlGradeGradesIntDto.getStatus());
            mdlGradeGradesDto.setNilai(mdlGradeGradesIntDto.getNilai());
            mdlGradeGradesDto.setNilaiAkhir(mdlGradeGradesIntDto.getNilaiAkhir());
            mdlGradeGradesDto.setBobot(mdlGradeGradesIntDto.getBobot());


            nilaitugasperuas2.add(mdlGradeGradesDto);
        }

        return nilaitugasperuas2;

    }



}
