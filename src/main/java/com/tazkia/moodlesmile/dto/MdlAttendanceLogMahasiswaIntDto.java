package com.tazkia.moodlesmile.dto;

import java.math.BigInteger;

public interface MdlAttendanceLogMahasiswaIntDto {

    BigInteger getId();
    String getIdTahunAkademik();
    String getNamaMatakuliah();
    String getIdJadwal();
    String getWaktuMasuk();
    String getWaktuSelesai();
    String getStatusPresensi();
    String getStatus();
    String getMahasiswa();


}
