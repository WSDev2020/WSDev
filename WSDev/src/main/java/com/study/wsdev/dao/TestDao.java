package com.study.wsdev.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

	String selectSysdate() throws Exception;
}
