package com.study.wsdev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.wsdev.vo.Modules;

@Controller
public class IndexController {
	@RequestMapping(value="/")
	public String root() {

		return Modules.APP.getPath("/index");
	}
}
