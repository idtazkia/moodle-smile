package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenIntDto;
import com.tazkia.moodlesmile.dto.MdlGradeItemsIntDto;
import com.tazkia.moodlesmile.entity.MdlGradeItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface MdlGradeItemsDao extends PagingAndSortingRepository<MdlGradeItems, BigInteger> {


//    @Query(value = "SET @row_number:=0\n" +
//            "SELECT id, idJadwal, namaTugas, bobot, status,\n" +
//            "@row_number:=CASE\n" +
//            "        WHEN @customer_no = idJadwal\n" +
//            "\t\t\tTHEN @row_number + 1\n" +
//            "        ELSE 1\n" +
//            "    END AS pertemuan,\n" +
//            "@customer_no:=idJadwal idJadwals\n" +
//            " FROM \n" +
//            "(SELECT a.id, d.shortname AS idJadwal, a.itemname AS namaTugas, ROUND((((a.aggregationcoef2 * 100) * (c.aggregationcoef2 * 100))/100),2) AS bobot, 'AKTIF' AS status\n" +
//            "FROM mdl_grade_items AS a \n" +
//            "INNER JOIN mdl_grade_categories AS b ON a.categoryid = b.id\n" +
//            "INNER JOIN mdl_grade_items AS c ON c.iteminstance = a.categoryid\n" +
//            "INNER JOIN mdl_course AS d ON a.courseid = d.id AND c.courseid = d.id\n" +
//            "WHERE b.fullname LIKE '%TUGAS%' AND d.fullname LIKE '%20201%') a\n" +
//            "ORDER BY idJadwal,id", nativeQuery = true)
//    List<MdlGradeItemsIntDto> findItemTugas();

    //find tugas
    @Query(value = "CALL GetjadwalBobotTugas4(?1)", nativeQuery = true)
    List<MdlGradeItemsIntDto> getItemTugas(String tahunAkademik);

}
