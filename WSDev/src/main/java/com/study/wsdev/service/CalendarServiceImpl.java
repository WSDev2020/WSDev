package com.study.wsdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.wsdev.dao.CalendarDao;
import com.study.wsdev.vo.CalendarVO;

@Transactional
@Service("calendarService")
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarDao calendarDao;
	
	public void saveData(CalendarVO calendarVO) throws Exception{
		calendarDao.saveData(calendarVO);
	}
}
