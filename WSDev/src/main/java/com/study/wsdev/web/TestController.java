
package com.study.wsdev.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.wsdev.service.TestService;

@Controller
public class TestController{
  	
  @Resource(name = "testService")
  private TestService testService;
	
  @RequestMapping(value ="/")
  public String test() throws Exception{
	  System.out.println("#####################sysdate:"+testService.selectSysdate());
	  return "test";
  }

}
