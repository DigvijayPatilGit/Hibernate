package com.one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_many_uni.entity.Mobile;
import com.one_to_many_uni.entity.Sim;

public class SaveMobile {

	public static void main(String[] args) {
		
		Sim sim1=new Sim();
		sim1.setProviderName("Airtel");
		sim1.setSimNumber(98653247);
		
		Sim sim2=new Sim();
		sim2.setProviderName("idea");
		sim2.setSimNumber(58463719);
		
		List<Sim> sims=new ArrayList();
		
		sims.add(sim1);
		sims.add(sim2);
		
		Mobile mobile=new Mobile();
		mobile.setMobileName("iphone");
		mobile.setBrand("Apple");
		mobile.setCost(144000.74);
		mobile.setSims(sims);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(mobile);
		em.persist(sim1);
		em.persist(sim2);
		et.commit();

	}

}
