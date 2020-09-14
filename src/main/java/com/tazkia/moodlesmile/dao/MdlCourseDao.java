package com.tazkia.moodlesmile.dao;

import com.tazkia.moodlesmile.entity.MdlCourse;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;

public interface MdlCourseDao extends PagingAndSortingRepository<MdlCourse, BigInteger> {



}
