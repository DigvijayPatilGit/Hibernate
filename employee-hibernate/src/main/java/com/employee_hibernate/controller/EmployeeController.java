package com.employee_hibernate.controller;

import com.employee_hibernate.dao.EmployeeTest;
import com.employee_hibernate.dto.Employee;

public class EmployeeController {

	public static void main(String[] args) {
		/*Employee e=new Employee();
		e.setEmpName("Rajan");
		e.setEmpRole("Manager");
		e.setSalary(125000.00);*/
		
		EmployeeTest empTest=new EmployeeTest();
		//empTest.saveDetails(e);
		
		//empTest.updateEmployee(2);
		
		empTest.deleteEmployee(3);
		
	}

}
