package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.domain.URole;
import com.cn.hnust.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	private static final Logger logger = LoggerFactory
			.getLogger(RoleController.class);

	@Resource
	private RoleService roleService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String permission(ModelMap modelMap) {
		List<URole> list = roleService.selectAll();
		modelMap.addAttribute("roleList", list);
		return "/role/index";
	}

}