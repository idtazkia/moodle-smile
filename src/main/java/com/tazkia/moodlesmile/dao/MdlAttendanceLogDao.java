package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.dto.MdlAttendanceLogDosenIntDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogMahasiswaIntDto;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

public interface MdlAttendanceLogDao extends PagingAndSortingRepository<MdlAttendanceLog, BigInteger> {

//    List<MdlAttendanceLog> findBySessionidAttendanceidCourseIdnumberAndIpaddressIsNotNull(List<MdlCourse> mdlCourse);




    //find dosen
    @Query(value = "SELECT b.id AS id, '6cf08aa7-fc62-40f3-b82d-ff04be2c8905' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.shortname AS idJadwal, FROM_UNIXTIME(a.timetaken, '%Y-%m-%d %h:%m:%s') AS waktuMasuk, \n" +
            "FROM_UNIXTIME(e.enddate, '%Y-%m-%d %h:%m:%s') AS waktuSelesai,'HADIR' AS statusPresensi, 'AKTIF' AS status, f.email AS idDosen, b.description AS beritaAcara\n" +
            "FROM mdl_attendance_log AS a \n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
            "WHERE e.fullname LIKE '%20201%' AND LENGTH(e.shortname)= 36 \n" +
            "GROUP BY b.id", nativeQuery = true)
    List<MdlAttendanceLogDosenIntDto> findJadwalSekarangDosen();


    @Query(value = "SELECT b.id AS id, '6cf08aa7-fc62-40f3-b82d-ff04be2c8905' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.shortname AS idJadwal, FROM_UNIXTIME(a.timetaken, '%Y-%m-%d %h:%m:%s') AS waktuMasuk, \n" +
            "FROM_UNIXTIME(e.enddate, '%Y-%m-%d %h:%m:%s') AS waktuSelesai,d.description AS statusPresensi, 'AKTIF' AS status, g.email AS mahasiswa\n" +
            "FROM mdl_attendance_log AS a \n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
            "WHERE e.fullname LIKE '%20201%' AND LENGTH(e.shortname)= 36", nativeQuery = true)
    List<MdlAttendanceLogMahasiswaIntDto> findJadwalSekarangMahasiswa();

    @Query(value = "SELECT b.id AS id, '6cf08aa7-fc62-40f3-b82d-ff04be2c8905' AS idTahunAkademik,e.fullname AS namaMatakuliah, e.shortname AS idJadwal, FROM_UNIXTIME(a.timetaken, '%Y-%m-%d %h:%m:%s') AS waktuMasuk, \n" +
            "FROM_UNIXTIME(e.enddate, '%Y-%m-%d %h:%m:%s') AS waktuSelesai,d.description AS statusPresensi, 'AKTIF' AS status, g.email AS mahasiswa\n" +
            "FROM mdl_attendance_log AS a \n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
            "INNER JOIN mdl_user AS f ON b.lasttakenby = f.id\n" +
            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
            "WHERE e.fullname LIKE '%20201%' AND LENGTH(e.shortname)= 36 and b.id = ?1", nativeQuery = true)
    List<MdlAttendanceLogMahasiswaIntDto> findJadwalSekarangMahasiswa2(String id);




}
