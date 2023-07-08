package com.one_to_many_bidirectional_hibernate.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.one_to_many_bidirectional_hibernate.entity.Mobile;

public class GetMobile_Named_Para_JPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		String q="select m from Mobile m where m.brand=:AnyStringName";
		Query query=em.createQuery(q);  //Query=ctr+space=javax.persistence package= enter
		query.setParameter("AnyStringName", "Apple");
		Mobile mobile=(Mobile) query.getSingleResult();   //Downcast for Single result mandatory remember
		System.out.println(mobile);
		
		//After all this coding add toString method in both entity classes and remove any referance object from anyone entity class of another entity class from tostring method

	}

}
