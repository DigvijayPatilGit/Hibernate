package com.one_to_many_bank.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.Query;
import com.one_to_many_bank.entity.Person;

public class GetPerson_JPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		String q="select p from Person p";
		javax.persistence.Query query=em.createQuery(q);
		List<Person> list=query.getResultList();
		for(Person person:list) {
			System.out.println(person);
			System.out.println("================");
		}
		

	}

}
