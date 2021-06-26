package com.lz.test.springboot.grocery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.lz.test.springboot.grocery.model.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
public class PersonController {
	@RequestMapping(value = "/login")
	public String Person(Model model) {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("application.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String classname=prop.getProperty("classname");
		String methodname=prop.getProperty("methodname");
		Class<?> perclazz=null;
		try {
			perclazz=Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method method = null;
		try {
			method = perclazz.getMethod(methodname);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			method.invoke(perclazz.newInstance());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person = new Person();
		model.addAttribute("msg", "<h1>fuck</h1>");
		return "login";

	}
}
