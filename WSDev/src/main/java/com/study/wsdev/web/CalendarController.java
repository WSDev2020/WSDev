package com.study.wsdev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.wsdev.vo.Modules;

@Controller
public class CalendarController {

	@RequestMapping(value="/calendar")
	public String getCalendarMain() {

		return Modules.APP.getPath("/calendar");
	}
}
