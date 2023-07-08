package com.voter_simple_project_hibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.voter_simple_project_hibernate.entity.Voter;

public class VoterCrud {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	Scanner sc=new Scanner(System.in);

	public void saveVoter(Voter v) {
		et.begin();
		em.persist(v);
		System.out.println("Voter Saved Successfully");
		System.out.println("*****************************");
		et.commit();
	}

	public List<Voter> getAllVoter() {
		String q = "select v from Voter v";
		Query query = em.createQuery(q);
		List<Voter> list = query.getResultList();
		for (Voter voter : list) {
			System.out.println("Voter id = " + voter.getId());
			System.out.println("Voter name = " + voter.getName());
			System.out.println("Voter vardNo = " + voter.getVardNo());
			System.out.println("Voter Address = " + voter.getAddress());
			System.out.println("***************************************");

		}
		return list;

	}

	public Voter getVoterById(int id) {
		String q = "select v from Voter v where v.id=?458";
		Query query = em.createQuery(q);
		query.setParameter(458, id);
		Voter voter = (Voter) query.getSingleResult();
		if (voter != null) {
			System.out.println("Voter id = " + voter.getId());
			System.out.println("Voter name = " + voter.getName());
			System.out.println("Voter vardNo = " + voter.getVardNo());
			System.out.println("Voter Address = " + voter.getAddress());
			System.out.println("***************************************");
		} else {
			System.out.println("No Such car with Given Id");
		}
		return voter;
	}

	public Voter getVoterByName(String name) {
		String q = "select v from Voter v where v.name=:yep";
		Query query = em.createQuery(q);
		query.setParameter("yep", name);
		Voter voter = (Voter) query.getSingleResult();
		if (voter != null) {
			System.out.println("Voter id = " + voter.getId());
			System.out.println("Voter name = " + voter.getName());
			System.out.println("Voter vardNo = " + voter.getVardNo());
			System.out.println("Voter Address = " + voter.getAddress());
			System.out.println("***************************************");
		}
		else {
			System.out.println("No Such car with Given Id");
		}
		return voter;
	}
	
	public boolean updateVoter(int id) {
		Voter voter=em.find(Voter.class, id);
		et.begin();
		if (voter != null) {
			System.out.println("Enter Updated Name");
			voter.setName(sc.next());
			System.out.println("Enter Updated vardno");
			voter.setVardNo(sc.nextInt());
			System.out.println("Enter Updated Address");
			voter.setAddress(sc.next());
			em.merge(voter);
			System.out.println("***************************************");
		}
		else {
			System.out.println("No Such car with Given Id");
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		Voter voter=em.find(Voter.class, id);
		et.begin();
		if(voter!=null) {
			em.remove(voter);
		}
		else {
			System.out.println("No Such car with Given Id");
		}
		et.commit();
		return false;
	}
	
	public boolean deleteByName(String name) {
		String q="select v from Voter v where v.name=:lol";
		Query query=em.createQuery(q);
		query.setParameter("lol", name);
		Voter voter=(Voter) query.getSingleResult();
		et.begin();
		if(voter!=null) {
			em.remove(voter);
		}
		else {
			System.out.println("No Such car with Given Id");
		}
		et.commit();
		return false;
	}

}
