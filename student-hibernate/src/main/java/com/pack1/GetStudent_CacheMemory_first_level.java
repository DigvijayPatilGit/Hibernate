package com.pack1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetStudent_CacheMemory_first_level {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("simha");
		
		//One query generated for one entity manager
		EntityManager em1=emf.createEntityManager();
		Student student=em1.find(Student.class, 1);
		//System.out.print("Student Name is :"+student.getName());
		System.out.println("******************************************");
		Student student2=em1.find(Student.class, 1);
		Student student3=em1.find(Student.class, 1);
		
		//Second query generated for Second entity manager
		EntityManager em2=emf.createEntityManager();
		Student student4=em2.find(Student.class, 1);
		Student student5=em2.find(Student.class, 1);
		Student student6=em2.find(Student.class, 1);

        //For every new entitymanager new quiry is generated
	}

}
