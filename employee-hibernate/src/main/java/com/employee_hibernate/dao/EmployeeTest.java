package com.employee_hibernate.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.employee_hibernate.dto.Employee;

public class EmployeeTest {
	
	Scanner sc=new Scanner(System.in);
	
	public void saveDetails(Employee e) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(e);
		et.commit();
		
	}
	public Employee getEmployee(int id) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		Employee e=em.find(Employee.class, id);
		return e;
		
	}
	public void updateEmployee(int id) {
		Scanner sc=new Scanner(System.in);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Employee e=em.find(Employee.class, id);
		et.begin();
		if(e!=null) {
			System.out.println("Enter Updated EmpName:-");
			e.setEmpName(sc.nextLine());
			System.out.println("Enter Updated EmpRole:-");
			e.setEmpRole(sc.nextLine());
			System.out.println("Enter Updated EmpSalary");
			e.setSalary(sc.nextDouble());
			em.merge(e);
		}
		else {
			System.out.println("There is no employee to Update");
		}
		et.commit();
	}
	public void deleteEmployee(int id) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Employee e=em.find(Employee.class, id);
		et.begin();
		if(e!=null) {
			em.remove(e);
		}
		else {
			System.out.println("No Employee To Delete");
		}
		et.commit();
	}

}
