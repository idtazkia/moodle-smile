package com.tazkia.moodlesmile.dto;

import java.math.BigInteger;

public interface MdlAttendanceLogIntDto {

    BigInteger getId();
    String getIdTahunAkademik();
    String getIdJadwal();
    String getWaktuMasuk();
    String getWaktuSelesai();
    String getStatusPresensi();
    String getStatus();
    String getIdDosen();
}
