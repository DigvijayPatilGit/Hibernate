package com.pack1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Student student =em.find(Student.class, 3);
		
		if(student!=null) {
			em.remove(student);
		}
		else {
			System.out.println("No Such Student found!");
		}
		et.commit();
		

	}

}
