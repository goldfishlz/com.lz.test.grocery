package com.lz.test.springboot.grocery.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lz.test.springboot.grocery.dao.EmployeeDao;
import com.lz.test.springboot.grocery.mojo.Department;
import com.lz.test.springboot.grocery.mojo.Employee;

@Controller
public class LoginController {

@Autowired
EmployeeDao employeeDao;
@RequestMapping("/user/login")
	public String login(
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			Model model,HttpSession session) {
		if ("admin".equals(username) && "123456".equals(password)) {
			session.setAttribute("loginUser", username);
			return "redirect:/main.html";
		} else {
			model.addAttribute("msg", "用户名或密码不正确");
			return "login";
		}

	}
}
