package com.study.wsdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.wsdev.dao.TestDao;

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDao testDao;
	
	public String selectSysdate() throws Exception {
		return testDao.selectSysdate();
	}

}
