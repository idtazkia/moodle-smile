package com.tazkia.moodlesmile.dto;


import com.sun.istack.NotNull;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import com.tazkia.moodlesmile.entity.MdlUser;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalTime;

@Data
public class MdlAttendanceLogDosenDto {

    private BigInteger idSession;
    private String idTahunAkademik;
    private String idJadwal;
    private String waktuMasuk;
    private String waktuSelesai;
    private String tanggalInput;
    private String statusPresensi;
    private String status;
    private String idDosen;
    private String beritaAcara;
    private String idLog;



}
