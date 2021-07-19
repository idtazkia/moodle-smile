package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenIntDto;
import com.tazkia.moodlesmile.dto.MdlGradeGradesIntDto;
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
    @Query(value = "CALL GetjadwalBobotTugas5(?1)", nativeQuery = true)
    List<MdlGradeItemsIntDto> getItemTugas(String tahunAkademik);
    //find tugas asli
    @Query(value = "CALL GetjadwalBobotAsliTugas7(?1)", nativeQuery = true)
    List<MdlGradeItemsIntDto> getItemAsliTugas(String tahunAkademik);

    //find uts
    @Query(value = "CALL GetJadwalBobotUts2(?1)", nativeQuery = true)
    List<MdlGradeItemsIntDto> getItemUts(String tahunAkademik);

    //find uas
    @Query(value = "CALL GetJadwalBobotUas2(?1)", nativeQuery = true)
    List<MdlGradeItemsIntDto> getItemUas(String tahunAkademik);


    @Query(value = "SELECT a.id, shortname AS idJadwal, email AS mahasiswa, idBobotTugas,finalgrade, 'AKTIF' AS STATUS, (finalgrade * bobot) /100 AS nilaiAkhir, bobot FROM \n" +
            "(SELECT a.id,a.finalgrade, ROUND((((b.aggregationcoef2 * 100) * (d.aggregationcoef2 * 100))/100),2) AS bobot,f.email,e.shortname,b.id AS idBobotTugas\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%TUGAS%' AND e.fullname LIKE '%20201%' AND a.finalgrade IS NOT NULL) a\n" +
            "ORDER BY idJadwal,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesTugas();

    @Query(value = "SELECT a.id, shortname AS idJadwal, email AS mahasiswa, idBobotTugas,finalgrade, 'AKTIF' AS STATUS, ROUND((SUM(finalgrade * bobot) /100),2) AS nilaiAkhir, bobot FROM \n" +
            "(SELECT a.id,a.finalgrade, ROUND((((b.aggregationcoef2 * 100) * (d.aggregationcoef2 * 100))/100),2) AS bobot,f.email,e.shortname,b.id AS idBobotTugas\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%TUGAS%' AND e.fullname LIKE '%20201%' and a.finalgrade IS NOT NULL) a\n" +
            "GROUP BY email, idJadwal\n" +
            "ORDER BY idJadwal,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesCountNilaiTugas();

    @Query(value = "SELECT a.id, shortname AS idJadwal, email AS mahasiswa, idBobotTugas,finalgrade, 'AKTIF' AS STATUS, (finalgrade * bobot) /100 AS nilaiAkhir, bobot FROM \n" +
            "(SELECT a.id,a.finalgrade, ROUND((((b.aggregationcoef2 * 100) * (d.aggregationcoef2 * 100))/100),2) AS bobot,f.email,e.shortname,b.id AS idBobotTugas\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%UTS%' AND e.fullname LIKE '%20201%' AND a.finalgrade IS NOT NULL) a\n" +
            "ORDER BY idJadwal,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesUts();

    @Query(value = "SELECT a.id, shortname AS idJadwal, email AS mahasiswa, idBobotTugas,finalgrade, 'AKTIF' AS STATUS, (finalgrade * bobot) /100 AS nilaiAkhir, bobot FROM \n" +
            "(SELECT a.id,a.finalgrade, ROUND((((b.aggregationcoef2 * 100) * (d.aggregationcoef2 * 100))/100),2) AS bobot,f.email,e.shortname,b.id AS idBobotTugas\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%UAS%' AND e.fullname LIKE '%20201%' AND a.finalgrade IS NOT NULL) a\n" +
            "ORDER BY idJadwal,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesUas();





    @Query(value = "SELECT id, idnumber as idNumber, idnumber AS idJadwal, mahasiswa,email as email, idBobotTugas,SUM(ROUND(finalgrade,2)) AS finalgrade, 'AKTIF' AS STATUS,sum(nilaiItem)as nilai, SUM(ROUND((nilaiItem * bobotCategory)/100,2)) AS nilaiAkhir,  bobotCategory AS bobot FROM \n" +
            "(\n" +
            "SELECT COALESCE(f.idnumber,f.username,f.email,f.id) AS mahasiswa, a.id,ROUND(((a.finalgrade * (b.aggregationcoef2 * 100))/ a.rawgrademax),2) AS nilaiItem,  a.finalgrade, a.rawgrademax, b.aggregationcoef2 * 100 AS bobotItem, d.aggregationcoef2 * 100 AS bobotCategory,f.email,e.shortname,b.id AS idBobotTugas, e.idnumber\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%TUGAS%' AND trim(e.idnumber) = ?1 AND a.finalgrade IS NOT NULL\n" +
            ") nilai_tugas_elearning where ROUND((bobotItem * bobotCategory)/100,2)  > 0\n" +
            "GROUP BY idnumber,mahasiswa\n" +
            "ORDER BY idnumber,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesTugas2(String jadwal);

    @Query(value = "SELECT id, idnumber as idNumber, idnumber AS idJadwal, mahasiswa, email as email, idBobotTugas,SUM(ROUND(finalgrade,2)) AS finalgrade, 'AKTIF' AS STATUS,sum(nilaiItem)as nilai, SUM(ROUND((nilaiItem * bobotCategory)/100,2)) AS nilaiAkhir,  bobotCategory AS bobot FROM \n" +
            "(\n" +
            "SELECT COALESCE(f.idnumber,f.username,f.email,f.id) AS mahasiswa, a.id,ROUND(((a.finalgrade * (b.aggregationcoef2 * 100))/ a.rawgrademax),2) AS nilaiItem,  a.finalgrade, a.rawgrademax, b.aggregationcoef2 * 100 AS bobotItem, d.aggregationcoef2 * 100 AS bobotCategory,f.email,e.shortname,b.id AS idBobotTugas, e.idnumber\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%UTS%' AND trim(e.idnumber) = ?1 AND a.finalgrade IS NOT NULL\n" +
            ") nilai_uts_elearning where ROUND((bobotItem * bobotCategory)/100,2)  > 0 \n" +
            "GROUP BY idnumber,mahasiswa\n" +
            "ORDER BY idnumber,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesUts2(String jadwal);

    @Query(value = "SELECT id, idnumber as idNumber, idnumber AS idJadwal, mahasiswa,email as email, idBobotTugas,SUM(ROUND(finalgrade,2)) AS finalgrade, 'AKTIF' AS STATUS,sum(nilaiItem)as nilai, SUM(ROUND((nilaiItem * bobotCategory)/100,2)) AS nilaiAkhir,  bobotCategory AS bobot FROM \n" +
            "(\n" +
            "SELECT COALESCE(f.idnumber,f.username,f.email,f.id) AS mahasiswa, a.id,ROUND(((a.finalgrade * (b.aggregationcoef2 * 100))/ a.rawgrademax),2) AS nilaiItem,  a.finalgrade, a.rawgrademax, b.aggregationcoef2 * 100 AS bobotItem, d.aggregationcoef2 * 100 AS bobotCategory,f.email,e.shortname,b.id AS idBobotTugas, e.idnumber\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%UAS%' AND trim(e.idnumber) = ?1 AND a.finalgrade IS NOT NULL\n" +
            ") nilai_uas_elearning where ROUND((bobotItem * bobotCategory)/100,2)  > 0 \n" +
            "GROUP BY idnumber,mahasiswa\n" +
            "ORDER BY idnumber,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesUas2(String jadwal);


    @Query(value = "SELECT id, idnumber, idnumber AS idJadwal, mahasiswa,email as email, idBobotTugas,SUM(ROUND(finalgrade,2)) AS finalgrade, 'AKTIF' AS STATUS,sum(nilai_item)as nilai, SUM(ROUND((nilai_item * bobot_category)/100,2)) AS nilaiAkhir,  bobot_category AS bobot FROM \n" +
            "(\n" +
            "SELECT COALESCE(f.idnumber,f.username,f.email,f.id) AS mahasiswa, a.id,ROUND(((a.finalgrade * (b.aggregationcoef2 * 100))/ a.rawgrademax),2) AS nilai_item,  a.finalgrade, a.rawgrademax, b.aggregationcoef2 * 100 AS bobot_item, d.aggregationcoef2 * 100 AS bobot_category,f.email,e.shortname,b.id AS idBobotTugas, e.idnumber\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%TUGAS%' AND trim(e.idnumber) = ?1 \n" +
            "and f.idnumber = ?2 AND a.finalgrade IS NOT NULL\n" +
            ") nilai_tugas_elearning where ROUND((bobot_item * bobot_category)/100,2)  > 0\n" +
            "GROUP BY idnumber,mahasiswa\n" +
            "ORDER BY idnumber,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesTugasPerMhs(String jadwal, String mahasiswa);

    @Query(value = "SELECT id, idnumber, idnumber AS idJadwal, mahasiswa,email as email, idBobotTugas,SUM(ROUND(finalgrade,2)) AS finalgrade, 'AKTIF' AS STATUS,sum(nilai_item)as nilai, SUM(ROUND((nilai_item * bobot_category)/100,2)) AS nilaiAkhir,  bobot_category AS bobot FROM \n" +
            "(\n" +
            "SELECT COALESCE(f.idnumber,f.username,f.email,f.id) AS mahasiswa, a.id,ROUND(((a.finalgrade * (b.aggregationcoef2 * 100))/ a.rawgrademax),2) AS nilai_item,  a.finalgrade, a.rawgrademax, b.aggregationcoef2 * 100 AS bobot_item, d.aggregationcoef2 * 100 AS bobot_category,f.email,e.shortname,b.id AS idBobotTugas, e.idnumber\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%UTS%' AND trim(e.idnumber) = ?1 \n" +
            "and f.idnumber = ?2 AND a.finalgrade IS NOT NULL\n" +
            ") nilai_tugas_elearning where ROUND((bobot_item * bobot_category)/100,2)  > 0\n" +
            "GROUP BY idnumber,mahasiswa\n" +
            "ORDER BY idnumber,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesUtsPerMhs(String jadwal, String mahasiswa);

    @Query(value = "SELECT id, idnumber, idnumber AS idJadwal, mahasiswa,email as email, idBobotTugas,SUM(ROUND(finalgrade,2)) AS finalgrade, 'AKTIF' AS STATUS,sum(nilai_item)as nilai, SUM(ROUND((nilai_item * bobot_category)/100,2)) AS nilaiAkhir,  bobot_category AS bobot FROM \n" +
            "(\n" +
            "SELECT COALESCE(f.idnumber,f.username,f.email,f.id) AS mahasiswa, a.id,ROUND(((a.finalgrade * (b.aggregationcoef2 * 100))/ a.rawgrademax),2) AS nilai_item,  a.finalgrade, a.rawgrademax, b.aggregationcoef2 * 100 AS bobot_item, d.aggregationcoef2 * 100 AS bobot_category,f.email,e.shortname,b.id AS idBobotTugas, e.idnumber\n" +
            "FROM mdl_grade_grades AS a\n" +
            "INNER JOIN mdl_grade_items AS b ON a.itemid = b.id\n" +
            "INNER JOIN mdl_grade_categories AS c ON b.categoryid = c.id\n" +
            "INNER JOIN mdl_grade_items AS d ON d.iteminstance = b.categoryid\n" +
            "INNER JOIN mdl_course AS e ON b.courseid = e.id AND d.courseid = e.id\n" +
            "INNER JOIN mdl_user  AS f ON a.userid = f.id\n" +
            "WHERE c.fullname LIKE '%UAS%' AND trim(e.idnumber) = ?1 \n" +
            "and f.idnumber = ?2 AND a.finalgrade IS NOT NULL\n" +
            ") nilai_tugas_elearning where ROUND((bobot_item * bobot_category)/100,2)  > 0\n" +
            "GROUP BY idnumber,mahasiswa\n" +
            "ORDER BY idnumber,mahasiswa;", nativeQuery = true)
    List<MdlGradeGradesIntDto> getGradesUasPerMhs(String jadwal, String mahasiswa);


}
