package com.pack1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestStudent {
	
	public static void main(String[] args) {
		Student student=new Student();
		//student.setId(3);
		student.setName("Mandy");
		student.setMarks(78);
		student.setLoc("Nashik");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();    //This is used for making changes/modification in database
		et.begin();
		em.persist(student);
		et.commit();           //To save the changes or Data
	}

}
