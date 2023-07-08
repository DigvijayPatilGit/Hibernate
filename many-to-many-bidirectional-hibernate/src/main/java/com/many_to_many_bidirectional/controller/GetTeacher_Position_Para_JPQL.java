package com.many_to_many_bidirectional.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.many_to_many_bidirectional.entity.Teacher;

public class GetTeacher_Position_Para_JPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		String q="select t from Teacher t where t.name=?152";  //Colon ":" and int value = Position Parameter
		Query query=em.createQuery(q);
		query.setParameter(152, "vinod");
		Teacher teacher=(Teacher) query.getSingleResult();
		System.out.println(teacher);

	}

}
