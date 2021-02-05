package com.tazkia.moodlesmile.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class MdlGradeGradesDto {

    private BigInteger id;
    private String idJadwal;
    private String mahasiswa;
    private BigInteger idBobotTugas;
    private BigDecimal nilai;
    private String status;
    private BigDecimal nilaiAkhir;
    private BigDecimal bobot;

}
