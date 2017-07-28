package com.sdp.mc.service.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ganquan
 *
 */
@Controller
@RequestMapping(value = { "/test" })
public class TesterAction {


	@RequestMapping("/test")
	public String test(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "/test/index";
	}

	
}
