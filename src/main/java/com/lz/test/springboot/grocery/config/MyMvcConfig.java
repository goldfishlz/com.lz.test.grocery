package com.lz.test.springboot.grocery.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index.html").setViewName("login");
		registry.addViewController("/main.html").setViewName("orderlist");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new Loginhandlerinterceptor()).
		addPathPatterns("/**").
		excludePathPatterns("/index.html","showlist.html","orderlist.html","/","/user/login","/assets/css/*","/assets/images/*");
		
	}

}
