package com.tazkia.moodlesmile.dto;


import java.math.BigDecimal;
import java.math.BigInteger;

public interface MdlGradeGradesIntDto {

    BigInteger getId();
    String getIdJadwal();
    String getMahasiswa();
    BigInteger getIdBobotTugas();
    BigDecimal getFinalgrade();
    String getStatus();
    BigDecimal getNilaiAkhir();
    BigDecimal getBobot();


}
