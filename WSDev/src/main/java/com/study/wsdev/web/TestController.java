
package com.study.wsdev.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.wsdev.service.TestService;

@Controller
public class TestController{
  	
  @Resource(name = "testService")
  private TestService testService;
	
  @RequestMapping(value ="/")
  public String test() throws Exception{

	  return "test";
  }
  
  @RequestMapping(value="/index")
  public String index(Model model) {

	  model.addAttribute("pageName", "dashboard");
	  return "index";
  }

}
