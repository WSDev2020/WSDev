
package com.study.wsdev.web;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.wsdev.service.TestService;

@Controller
public class TestController{

  final static Logger logger = Logger.getLogger(TestController.class);
  	
  @Resource(name = "testService")
  private TestService testService;
	
  @RequestMapping(value ="/")
  public String test(Model model) throws Exception{
	  model.addAttribute("pageName", "test");
	  logger.info("This is info Test");
	  return "test";
  }
  
  @RequestMapping(value="/index")
  public String index(Model model) {

	  model.addAttribute("pageName", "dashboard");
	  return "index";
  }

}
