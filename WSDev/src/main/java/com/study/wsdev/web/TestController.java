
package com.study.wsdev.web;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.wsdev.service.TestService;

@Controller
public class TestController{

  final static Logger logger = Logger.getLogger(TestController.class);
  	
  @Resource(name = "testService")
  private TestService testService;
	
  @RequestMapping(value ="/")
  public String test() throws Exception{
	  System.out.println("#####################sysdate:"+testService.selectSysdate());
	  logger.info("This is info Test");
	  return "test";
  }
  
  @RequestMapping(value="/index")
  public String index() {
	  System.out.println("메인페이지입니다.");
	  return "index";
  }

}
