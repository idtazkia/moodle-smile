package com.tazkia.moodlesmile.dto;

import java.math.BigInteger;

public interface MdlAttendanceLogDosenIntDto {

    BigInteger getId();
    String getIdTahunAkademik();
    String getNamaMatakuliah();
    String getIdJadwal();
    String getWaktuMasuk();
    String getWaktuSelesai();
    String getTanggalInput();
    String getStatusPresensi();
    String getStatus();
    String getIdDosen();
    String getBeritaAcara();
    String getIdLog();
}
