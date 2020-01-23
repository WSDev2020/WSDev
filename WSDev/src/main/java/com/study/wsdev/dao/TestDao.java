package com.study.wsdev.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	@Autowired 
	public SqlSessionTemplate sqlSession;
	
	public String selectSysdate() throws Exception {
		return sqlSession.selectOne("com.study.wsdev.dao.TestDao.selectSysdate");
	}
}
