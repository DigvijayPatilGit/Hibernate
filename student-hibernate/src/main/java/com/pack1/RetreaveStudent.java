package com.pack1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RetreaveStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		Student student=em.find(Student.class, 3);
		System.out.println("Student id is: "+student.getId());
		System.out.println("Student Name is: "+student.getName());
		System.out.println("Student Location is: "+student.getLoc());
		System.out.println("Student Marks is: "+student.getMarks());

	}

}
