package com.one_to_many_bank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.one_to_many_bank.entity.Bank;
import com.one_to_many_bank.entity.Person;

public class PersonController {

	public static void main(String[] args) {
		
		Bank b1=new Bank();
		b1.setAccNo(10001);
		b1.setAddress("Shivaji nagar");
		b1.setBankName(" Bank");
		b1.setIfsc("STA01");
		
		Bank b2=new Bank();
		b2.setAccNo(10001);
		b2.setAddress("Bagava Chauk");
		b2.setBankName("Union Bank");
		b2.setIfsc("UBI01");
		
		Bank b3=new Bank();
		b3.setAccNo(10001);
		b3.setAddress("Pratap nagar");
		b3.setBankName("Axis Bank");
		b3.setIfsc("AXI01");
		
		List<Bank> list=new ArrayList<Bank>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		//Transient Object makes first to store inside main object
		Person person=new Person();
		person.setName("Rakesh");
		person.setAddress("Sambhaji Nagar");
		person.setAge(23);
		person.setPhoneNo(121212121);
		person.setBankAccount(list);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(person);
		et.commit();
	

	}

}
