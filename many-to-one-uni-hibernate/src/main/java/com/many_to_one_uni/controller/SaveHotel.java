package com.many_to_one_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.many_to_one_uni.entity.Branch;
import com.many_to_one_uni.entity.Hotel;

public class SaveHotel {

	public static void main(String[] args) {
		
		Hotel h=new Hotel();
		h.setName("Oberoi Hotels");
		h.setAddress("Mumbai");
		h.setManagerName("The Oberoi Group");
		
		Branch b1=new Branch();
		b1.setAddress("Jaipur");
		b1.setManagerName("Dara Singh");
		b1.setPhoneNo(12312313);
		b1.setHotel(h);
		
		Branch b2=new Branch();
		b2.setAddress("Jodhpur");
		b2.setManagerName("Tony Singh");
		b2.setPhoneNo(12312414);
		b2.setHotel(h);
		
		Branch b3=new Branch();
		b3.setAddress("Udaipur");
		b3.setManagerName("Dipti Raval");
		b3.setPhoneNo(12312515);
		b3.setHotel(h);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		et.commit();
		
		

	}

}
