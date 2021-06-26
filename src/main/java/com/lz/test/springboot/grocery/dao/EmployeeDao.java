package com.lz.test.springboot.grocery.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lz.test.springboot.grocery.mojo.Department;
import com.lz.test.springboot.grocery.mojo.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    
    private static Map<Integer, Employee> employees=null;
    @Autowired
    private DepartmentDao departmentDao;
    
    static{
        employees=new HashMap<Integer,Employee>();
        
        employees.put(101,new Employee(101,"pingpang","dlxiaozhi@hotmail.com",0,new Department(1001,"sports")));
        employees.put(102,new Employee(102,"basketball","jarrodlz@hotmail.com",1,new Department(1002,"sports")));
        employees.put(103,new Employee(103,"volleball","jackwillam@hotmail.com",1,new Department(1003,"sports")));
        employees.put(104,new Employee(104,"football","tomhanks@hotmail.com",0,new Department(1004,"sports")));

    }
    
    private static Integer initId=1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentId(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    public Collection<Employee> getAll(){
    	
        return employees.values();
    }
    public Employee getEmployeeId(Integer id){
        return employees.get(id);
    }
    public void delete(Integer id){
        employees.remove(id);
    }
}
