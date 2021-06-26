package com.lz.test.springboot.grocery.dao;

import org.springframework.stereotype.Repository;

import com.lz.test.springboot.grocery.mojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
	private static Map<Integer, Department> departments = null;
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(1001, "sports"));
		departments.put(102, new Department(1002, "talk"));
		departments.put(103, new Department(1003, "reed"));
		departments.put(104, new Department(1004, "smell"));
		departments.put(105, new Department(1005, "cock"));
	}

	public Collection<Department> getDepartments() {
		return departments.values();

	}

	public Department getDepartmentId(Integer id) {
		return departments.get(id);
	}
}
