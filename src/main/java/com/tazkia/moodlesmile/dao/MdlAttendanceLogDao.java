package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.dto.MdlAttendanceLogDto;
import com.tazkia.moodlesmile.dto.MdlAttendanceLogIntDto;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import com.tazkia.moodlesmile.entity.MdlCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

public interface MdlAttendanceLogDao extends PagingAndSortingRepository<MdlAttendanceLog, BigInteger> {

//    List<MdlAttendanceLog> findBySessionidAttendanceidCourseIdnumberAndIpaddressIsNotNull(List<MdlCourse> mdlCourse);




    //find dosen
    @Query(value = "SELECT b.id AS id, '6cf08aa7-fc62-40f3-b82d-ff04be2c8905' AS idTahunAkademik, e.shortname AS idJadwal, FROM_UNIXTIME(a.timetaken, '%d/%m/%Y %h:%m:%s') AS waktuMasuk, \n" +
            "FROM_UNIXTIME(e.enddate, '%d/%m/%Y %h:%m:%s') AS waktuSelesai,'HADIR' AS statusPresensi, 'AKTIF' AS status, f.email AS idDosen\n" +
            "FROM mdl_attendance_log AS a \n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid = b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id \n" +
            "INNER JOIN mdl_attendance_statuses AS d ON c.id = d.attendanceid AND a.statusid = d.id\n" +
            "INNER JOIN mdl_course AS e ON c.course = e.id\n" +
            "INNER JOIN mdl_user AS f ON a.takenby = f.id\n" +
            "INNER JOIN mdl_user AS g ON a.studentid = g.id\n" +
            "WHERE e.fullname LIKE '%20201%'\n" +
            "GROUP BY b.id;", nativeQuery = true)
    List<MdlAttendanceLogIntDto> findJadwalSekarang();


}
