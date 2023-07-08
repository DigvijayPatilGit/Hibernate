package com.one_to_one_uni_mapping.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_one_uni_mapping.entity.Aadhar;
import com.one_to_one_uni_mapping.entity.Person;

public class PersonController {

	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Lokesh");
		p.setAddress("Pune");
		
		Aadhar aadhar=new Aadhar();
		aadhar.setAadharNo(89899896);
		aadhar.setFatherName("Satish");
		p.setAadhar(aadhar);               //first we have to create aadhar object to store inside the Person details
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(aadhar);
		em.persist(p);
		et.commit();
	}

}
