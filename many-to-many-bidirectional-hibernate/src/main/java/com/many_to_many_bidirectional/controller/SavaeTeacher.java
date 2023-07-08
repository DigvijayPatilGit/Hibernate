package com.many_to_many_bidirectional.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.many_to_many_bidirectional.entity.Subject;
import com.many_to_many_bidirectional.entity.Teacher;

public class SavaeTeacher {

	public static void main(String[] args) {
		List<Teacher> list=new ArrayList();

		Teacher t1=new Teacher();
		t1.setName("Vinod");
		t1.setAge(33);
		t1.setAddress("Delhi");
		
		Teacher t2=new Teacher();
		t2.setName("Babu");
		t2.setAge(25);
		t2.setAddress("Kochi");
		
		Teacher t3=new Teacher();
		t3.setName("Prasad");
		t3.setAge(30);
		t3.setAddress("Kolkata");
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
		
		Subject s1=new Subject();
		s1.setName("Core Java");
		s1.setDuration(56);
		s1.setTeachers(list);
		
		Subject s2=new Subject();
		s2.setName("SQL");
		s2.setDuration(35);
		s2.setTeachers(list);
		
		Subject s3=new Subject();
		s3.setName("Python");
		s3.setDuration(50);
		s3.setTeachers(list);
		
		List<Subject> list2=new ArrayList();
		list2.add(s1);
		list2.add(s2);
		list2.add(s3);
		
		t1.setSubjects(list2);
		t2.setSubjects(list2);
		t3.setSubjects(list2);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("digvijay");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		et.commit();
	}

}
