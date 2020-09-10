package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.entity.MdlAttendanceSessions;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;

public interface MdlAttendanceSessionsDao extends PagingAndSortingRepository<MdlAttendanceSessions, BigInteger> {


}
