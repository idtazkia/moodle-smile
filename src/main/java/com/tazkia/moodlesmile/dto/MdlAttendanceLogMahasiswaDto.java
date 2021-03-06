package com.tazkia.moodlesmile.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class MdlAttendanceLogMahasiswaDto {


    private BigInteger idSession;
    private String idTahunAkademik;
    private String idJadwal;
    private String waktuMasuk;
    private String waktuSelesai;
    private String statusPresensi;
    private String status;
    private String mahasiswa;

}
