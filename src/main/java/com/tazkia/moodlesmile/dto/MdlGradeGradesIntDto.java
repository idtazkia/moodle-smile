package com.tazkia.moodlesmile.dto;


import java.math.BigDecimal;
import java.math.BigInteger;

public interface MdlGradeGradesIntDto {

    BigInteger getId();
    String getIdNumber();
    String getIdJadwal();
    String getMahasiswa();
    BigInteger getIdBobotTugas();
    BigDecimal getFinalgrade();
    BigDecimal getNilai();
    String getStatus();
    BigDecimal getNilaiAkhir();
    BigDecimal getBobot();


}
