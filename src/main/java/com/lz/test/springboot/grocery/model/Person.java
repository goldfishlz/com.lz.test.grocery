package com.lz.test.springboot.grocery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
	private String name;
    private Integer age;
    private String email;
    private Boolean happy;
    private Map<String,Object> maps=new HashMap<String,Object>();
    private List<Object> lists=new ArrayList<Object>();
    private Date birth;
}
