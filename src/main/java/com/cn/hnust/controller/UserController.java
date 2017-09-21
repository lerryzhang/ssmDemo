package com.cn.hnust.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.domain.UPermission;
import com.cn.hnust.domain.User;
import com.cn.hnust.service.PermissionService;
import com.cn.hnust.service.UserService;
import com.cn.hnust.util.MyUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@Resource
	private PermissionService permissionService;

	@RequestMapping(value = "/showUser/{id}", method = RequestMethod.GET)
	public String toIndex(@PathVariable("id") Integer id,
			HttpServletRequest request, Model model) {
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		return "user/showUser";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String helloUser(ModelMap modelMap) {
		List<User> list = userService.findAllUser();
		modelMap.addAttribute("userList", list);
		return "/user/userlist";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		return "/user/index";
	}

	@RequestMapping(value = "/indexs", method = RequestMethod.GET)
	public String indexs(ModelMap modelMap) {
		return "/user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean remember = Boolean.parseBoolean(request
				.getParameter("rememberMe"));
		if ((username != null && password != null)) {
			UsernamePasswordToken token = new UsernamePasswordToken(username,
					password);
			token.setRememberMe(remember);
			Subject subject = SecurityUtils.getSubject();
			try {
				subject.login(token);
				request.getSession().setAttribute("username", username);
				map.put("status", "200");
				map.put("msg", "登录成功");
			} catch (UnknownAccountException uae) {
				map.put("status", "500");
				map.put("msg", "账号不存在");

			} catch (IncorrectCredentialsException ice) {
				map.put("status", "500");
				map.put("msg", "账号或密码不正确");

			} catch (LockedAccountException lae) {
				map.put("status", "500");
				map.put("msg", "账号被锁住,请联系管理员解锁");
			} catch (ExcessiveAttemptsException eae) {
				map.put("status", "500");
				map.put("msg", "账号或密码不正确");

			} catch (AuthenticationException ae) {
				map.put("status", "500");
				map.put("msg", "用户名或密码错误");

			}

		}
		return map;
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> logout() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SecurityUtils.getSubject().logout();
			map.put("status", "200");
			map.put("msg", "登出成功");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("msg", e.getMessage());
			logger.error(String.format("错误日志===%s", e.getMessage()));
		}
		return map;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		map.put("status", 400);
		User user = userService.selectByEmail(email);
		if (null != user) {
			map.put("message", "帐号|Email已经存在！");
			return map;
		}
		user = new User();
		user.setNickname(username);
		user.setPswd(MyUtils.getMD5(password));
		user.setEmail(email);
		user.setStatus(User._0);
		userService.saveUser(user);

		map.put("message", "注册成功！");
		map.put("status", 200);

		return map;
	}

	@RequestMapping(value = "/permission", method = RequestMethod.GET)
	public String permission(ModelMap modelMap) {
		List<UPermission> list = permissionService.findAllPermission();
		modelMap.addAttribute("permissionList", list);
		return "/permission/index";
	}

}