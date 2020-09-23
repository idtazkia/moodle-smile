package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.dto.MdlAttendanceLogDto;
import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import com.tazkia.moodlesmile.entity.MdlCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

public interface MdlAttendanceLogDao extends PagingAndSortingRepository<MdlAttendanceLog, BigInteger> {

//    List<MdlAttendanceLog> findBySessionidAttendanceidCourseIdnumberAndIpaddressIsNotNull(List<MdlCourse> mdlCourse);




    @Query(value = "SELECT *, FROM_UNIXTIME (b.lasttaken, '%d/%m/%Y') AS taken\n" +
            "FROM mdl_attendance_log AS a\n" +
            "INNER JOIN mdl_attendance_sessions AS b ON a.sessionid - b.id\n" +
            "INNER JOIN mdl_attendance AS c ON b.attendanceid = c.id\n" +
            "INNER JOIN mdl_course AS d ON c.course = d.id\n" +
            "INNER JOIN mdl_user AS e on a.studentid = e.id\n" +
            "WHERE b.lasttaken IS NOT NULL\n" +
            "AND FROM_UNIXTIME (b.lasttaken, '%d/%m/%Y') = DATE_FORMAT(NOW(), '%d/%m/%Y') AND ipaddress IS NOT NULL \n" +
            "AND d.idnumber LIKE '%20201%';", nativeQuery = true)
    List<MdlAttendanceLog> findJadwalSekarang();


}
