package com.one_to_many_bidirectional_hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_many_bidirectional_hibernate.entity.Mobile;
import com.one_to_many_bidirectional_hibernate.entity.Sim;

public class SaveMobile {

	public static void main(String[] args) {
		
		Sim s1=new Sim();
		s1.setProvider("Airtel");
		s1.setImrcNo("air1212");
		s1.setSimNo(12365999);
		
		Sim s2=new Sim();
		s2.setProvider("jio");
		s2.setImrcNo("jio5678");
		s2.setSimNo(89788999);
		
		List<Sim> list=new ArrayList<Sim>();
		list.add(s1);
		list.add(s2);
		
		Mobile m= new Mobile();
		m.setName("i-Phone 14 pro Max");
		m.setBrand("Apple");
		m.setCost(140000.36);
		m.setSims(list);
		
		s1.setMobile(m);
		s2.setMobile(m);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(m);
		et.commit();
		
		
		

	}

}
