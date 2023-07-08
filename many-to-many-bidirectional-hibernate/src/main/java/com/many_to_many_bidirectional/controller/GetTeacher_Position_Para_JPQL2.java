package com.many_to_many_bidirectional.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.many_to_many_bidirectional.entity.Teacher;

public class GetTeacher_Position_Para_JPQL2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		String q="select t from Teacher t where t.address=?458";
		Query query=em.createQuery(q);
		query.setParameter(458, "kochi");
		Teacher teacher=(Teacher) query.getSingleResult();
		System.out.println("Teacher id = "+teacher.getId());
		System.out.println("Teacher Name = "+teacher.getName());
		System.out.println("Teacher Age = "+teacher.getAge());
		System.out.println("Teacher id = "+teacher.getAddress());		
		System.out.println("Subject Teaches = "+teacher.getSubjects());

		
	}

}
