package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenIntDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogMahasiswaIntDto;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface MdlAttendanceLogDao extends PagingAndSortingRepository<MdlAttendanceLog, BigInteger> {

//    List<MdlAttendanceLog> findBySessionidAttendanceidCourseIdnumberAndIpaddressIsNotNull(List<MdlCourse> mdlCourse);

    @Modifying
    @Query(value = "update mdl_attendance_log set statusimport = 'Berhasil' where sessionid = ?1", nativeQuery = true)
    void updateMdlLog(BigInteger id);

    //find dosen
    @Query(value = "SELECT b.id AS id, 'ac02591c-2f3a-498e-9a91-404e96294d9d' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.idnumber AS idJadwal, FROM_UNIXTIME(b.sessdate, '%Y-%m-%d') AS waktuMasuk, \n" +
            "FROM_UNIXTIME(b.sessdate, '%Y-%m-%d') AS waktuSelesai,FROM_UNIXTIME(a.timetaken, '%Y-%m-%d') as tanggalInput,'HADIR' AS statusPresensi, 'AKTIF' AS status, f.email AS idDosen, b.description AS beritaAcara, a.id as idLog\n" +
            "FROM mdl_attendance_log AS a \n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
            "WHERE e.fullname LIKE '%20202%' AND LENGTH(e.idnumber)= 36 AND a.statusimport is null AND FROM_UNIXTIME(b.sessdate, '%Y-%m-%d') = ?1 \n" +
            "GROUP BY b.id", nativeQuery = true)
    List<MdlAttendanceLogDosenIntDto> findJadwalSekarangDosen(LocalDate tanggalImport);


//    @Query(value = "SELECT b.id AS id, '6cf08aa7-fc62-40f3-b82d-ff04be2c8905' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.shortname AS idJadwal, FROM_UNIXTIME(b.sessdate, '%Y-%m-%d') AS waktuMasuk, \n" +
//            "FROM_UNIXTIME(b.sessdate, '%Y-%m-%d') AS waktuSelesai,'HADIR' AS statusPresensi, 'AKTIF' AS status, f.email AS idDosen, b.description AS beritaAcara, a.id as idLog\n" +
//            "FROM mdl_attendance_log AS a \n" +
//            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
//            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
//            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
//            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
//            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
//            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
//            "WHERE e.fullname LIKE '%20201%' AND LENGTH(e.shortname)= 36 AND a.statusimport is null and e.shortname = 'f71456f4-0868-11eb-9fd2-76de2a7fe195' \n" +
//            "GROUP BY b.id", nativeQuery = true)
//    List<MdlAttendanceLogDosenIntDto> findJadwalSekarangDosen2();

//    @Query(value = "SELECT b.id AS id, 'ac02591c-2f3a-498e-9a91-404e96294d9d' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.shortname AS idJadwal, FROM_UNIXTIME(b.sessdate, '%Y-%m-%d') AS waktuMasuk, \n" +
//            "FROM_UNIXTIME(b.sessdate, '%Y-%m-%d') AS waktuSelesai,'HADIR' AS statusPresensi, 'AKTIF' AS status, f.email AS idDosen, b.description AS beritaAcara, a.id as idLog\n" +
//            "FROM mdl_attendance_log AS a \n" +
//            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
//            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
//            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
//            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
//            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
//            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
//            "WHERE e.fullname LIKE '%20202%' AND LENGTH(e.shortname)= 36 AND a.statusimport is null and e.shortname = 'f71456f4-0868-11eb-9fd2-76de2a7fe195' \n" +
//            "GROUP BY b.id", nativeQuery = true)
//    List<MdlAttendanceLogDosenIntDto> findJadwalSekarangDosen2();


    @Query(value = "SELECT b.id AS id, 'ac02591c-2f3a-498e-9a91-404e96294d9d' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.idnumber AS idJadwal, FROM_UNIXTIME(a.timetaken, '%Y-%m-%d %h:%m:%s') AS waktuMasuk, \n" +
            "FROM_UNIXTIME(e.enddate, '%Y-%m-%d %h:%m:%s') AS waktuSelesai,d.description AS statusPresensi, 'AKTIF' AS status, g.email AS mahasiswa\n" +
            "FROM mdl_attendance_log AS a \n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
            "WHERE e.fullname LIKE '%20202%' AND LENGTH(e.idnumber)= 36 AND a.statusimport is null", nativeQuery = true)
    List<MdlAttendanceLogMahasiswaIntDto> findJadwalSekarangMahasiswa();

    @Query(value = "SELECT b.id AS id, 'ac02591c-2f3a-498e-9a91-404e96294d9d' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.idnumber AS idJadwal, FROM_UNIXTIME(b.sessdate, '%Y-%m-%d %h:%m:%s') AS waktuMasuk, \n" +
            "FROM_UNIXTIME(b.sessdate, '%Y-%m-%d %h:%m:%s') AS waktuSelesai,d.description AS statusPresensi, 'AKTIF' AS status, g.email AS mahasiswa\n" +
            "FROM mdl_attendance_log AS a \n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
            "WHERE e.fullname LIKE '%20202%' AND LENGTH(e.idnumber)= 36 and b.id = ?1", nativeQuery = true)
    List<MdlAttendanceLogMahasiswaIntDto> findJadwalSekarangMahasiswa2(String id);




}
