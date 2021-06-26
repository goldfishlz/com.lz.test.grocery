package com.lz.test.springboot.grocery.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lz.test.springboot.grocery.dao.EmployeeDao;
import com.lz.test.springboot.grocery.mojo.Employee;

@Controller
public class EmployeeController {
@Autowired
EmployeeDao employeeDao;
@RequestMapping("/showlist")
public String List(Model model) {
	Collection<Employee> employees=employeeDao.getAll();
	model.addAttribute("emps",employees);
	return "showlist";
}
}
