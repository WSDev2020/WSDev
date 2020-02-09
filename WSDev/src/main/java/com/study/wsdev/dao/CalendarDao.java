package com.study.wsdev.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.wsdev.vo.CalendarVO;

@Repository
public class CalendarDao {

	@Autowired 
	public SqlSessionTemplate sqlSession;
	
	public void saveData(CalendarVO calendarVO) throws Exception{
		sqlSession.insert("com.study.wsdev.dao.CalendarDao.saveData", calendarVO);
	}
}
