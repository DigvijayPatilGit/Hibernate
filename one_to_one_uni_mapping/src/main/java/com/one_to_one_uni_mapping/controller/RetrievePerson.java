package com.one_to_one_uni_mapping.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.Query;
import com.one_to_one_uni_mapping.entity.Person;

public class RetrievePerson {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		EntityManager em=emf.createEntityManager();
		String q="select p from person p";
		javax.persistence.Query query=em.createQuery(q);
		List<Person> list=query.getResultList();
		for(Person p:list) {
			System.out.println(p);
			System.out.println("***********************");
		}

	}

}
