package com.many_to_many_uni_hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.many_to_many_uni_hibernate.entity.Subject;
import com.many_to_many_uni_hibernate.entity.Teacher;

public class SaveTeacher {

	public static void main(String[] args) {
		
		Subject s1=new Subject();
		s1.setSubName("Maths");
		s1.setDuration(6);
		
		Subject s2=new Subject();
		s2.setSubName("Science");
		s2.setDuration(6);
		
		Subject s3=new Subject();
		s3.setSubName("History");
		s3.setDuration(6);
		
		List<Subject> list=new ArrayList();
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		Teacher teacher=new Teacher();
		teacher.setName("Mala");
		teacher.setAge(27);
		teacher.setAddress("Banglore");
		teacher.setSubjects(list);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(teacher);
		et.commit();

	}

}
