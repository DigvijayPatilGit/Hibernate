package com.one_to_many_bidirectional_hibernate.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.one_to_many_bidirectional_hibernate.entity.Mobile;

public class GetTeacher_Named_Para_JPQL2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		String q="select m from Mobile m where m.name=:MereBhai";
		Query query=em.createQuery(q);
		query.setParameter("MereBhai", "i-Phone 14 pro Max");
		Mobile mobile=(Mobile) query.getSingleResult();
		System.out.println("Mobile Brand : "+mobile.getBrand());
		System.out.println("Mobile Name : "+mobile.getName());
		System.out.println("Mobile Brand : "+mobile.getCost());
		System.out.println("Mobile Brand : "+mobile.getId());
		System.out.println("Mobile Brand : "+mobile.getSims());
	}

}
