package com.one_to_many_bidirctional.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_many_bidirctional.entity.PanCard;
import com.one_to_many_bidirctional.entity.Person;

public class SavePerson {

	public static void main(String[] args) {
		
		PanCard card=new PanCard();
		card.setNumber("eqpt123");
		card.setFatherName("Jugnu");
		
		Person person=new Person();
		person.setName("Rocky");
		person.setAddress("KGF");
		person.setAge(30);
		person.setCard(card);
		
		card.setPerson(person);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(person);
		em.persist(card);
		et.commit();
		

	}

}
