package com.cn.hnust.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("common")
public class CommonController {
	@RequestMapping("404")
	public String _404() {
		return "/common/error404";
	}

	@RequestMapping("500")
	public String _500() {
		return "/common/error500";
	}

}
