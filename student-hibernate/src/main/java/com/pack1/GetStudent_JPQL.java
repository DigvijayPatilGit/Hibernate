package com.pack1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetStudent_JPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		String q="select p from Student p";
		javax.persistence.Query query=em.createQuery(q);
		List<Student> list=query.getResultList();
		for(Student s:list) {
			System.out.println(s);
			System.out.println("***********************");
		}

	}

}
