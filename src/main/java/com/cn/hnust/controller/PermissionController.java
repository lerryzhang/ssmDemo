package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.domain.UPermission;
import com.cn.hnust.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	private static final Logger logger = LoggerFactory
			.getLogger(PermissionController.class);

	@Resource
	private PermissionService permissionService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String permission(ModelMap modelMap) {
		List<UPermission> list = permissionService.findAllPermission();
		modelMap.addAttribute("permissionList", list);
		return "/permission/index";
	}

}