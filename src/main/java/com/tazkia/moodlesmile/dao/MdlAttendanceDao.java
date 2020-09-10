package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.entity.MdlAttendance;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;

public interface MdlAttendanceDao extends PagingAndSortingRepository<MdlAttendance, BigInteger> {


}
