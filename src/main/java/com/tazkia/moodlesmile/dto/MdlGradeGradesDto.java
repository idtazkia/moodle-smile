package com.tazkia.moodlesmile.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class MdlGradeGradesDto {

    private BigInteger id;
    private String idNumber;
    private String idJadwal;
    private String mahasiswa;
    private String email;
    private BigInteger idBobotTugas;
    private BigDecimal finalgrade;
    private BigDecimal nilai;
    private String status;
    private BigDecimal nilaiAkhir;
    private BigDecimal bobot;

}
