package com.pack1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Student student=em.find(Student.class, 2);
		
		et.begin();
		student.setName("Ronak");
		student.setLoc("Hyd");
		student.setMarks(98);
		
		em.merge(student);
		et.commit();

	}

}
