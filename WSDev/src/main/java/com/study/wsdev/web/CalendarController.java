package com.study.wsdev.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.wsdev.service.CalendarService;
import com.study.wsdev.vo.CalendarVO;
import com.study.wsdev.vo.Modules;

@Controller
public class CalendarController {
	
	@Resource(name="calendarService")
	private CalendarService calendarService;

	@RequestMapping(value="/calendar")
	public String getCalendarMain() {

		return Modules.APP.getPath("/calendar");
	}

	@RequestMapping(value="/calendar/addData")
	public @ResponseBody String saveCalendarData(@RequestBody CalendarVO calendarVO) {
		String msg = "";
		try {
			calendarService.saveData(calendarVO);
			msg = "Data save success";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Data save failed";
		}
		return msg;
	}
}
