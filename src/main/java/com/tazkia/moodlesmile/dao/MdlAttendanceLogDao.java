package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.entity.MdlAttendanceLog;
import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

public interface MdlAttendanceLogDao extends PagingAndSortingRepository<MdlAttendanceLog, BigInteger> {

//    MdlAttendanceLog findBySessionid(MdlAttendanceSessions session);
    List<MdlAttendanceLog> findBySessionid(MdlAttendanceSessions session);


}
