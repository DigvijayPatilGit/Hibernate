package com.car_simple_project.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.car_simple_project.entity.Car;

public class CarCrud {

	public void saveCar(Car car) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(car);
		System.out.println("Car Details Saved Successfully");
		System.out.println("************************************");
		et.commit();
	}

	public List<Car> getAllCars() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		String q = "select c from Car c";
		Query query = em.createQuery(q);
		List<Car> list = query.getResultList();
		for (Car car : list) {
			System.out.println("Car Id : " + car.getId());
			System.out.println("Car Name : " + car.getName());
			System.out.println("Car Brand : " + car.getBrand());
			System.out.println("Car Cost : " + car.getCost());
			System.out.println("************************************");
		}
		return list;
	}

	public Car getCarById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		String q = "select c from Car c where c.id =?1254";
		Query query = em.createQuery(q);
		query.setParameter(1254, id);
		Car car = (Car) query.getSingleResult();  
		if (car != null) {
			System.out.println("Car Id : "+car.getId());
			System.out.println("Car Name : " + car.getName());
			System.out.println("Car Brand : " + car.getBrand());
			System.out.println("Car Cost : " + car.getCost());
			System.out.println("************************************");

		} else {
			System.out.println("No Such car with Given Id");
		}
		return car;
	}

	public Car getCarByName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		String q="select c from Car c where c.name=?1";
		Query query=em.createQuery(q);
		query.setParameter(1, name);
		Car car=(Car) query.getSingleResult();
		if(car!=null) {
			System.out.println("Car Id : " + car.getId());
			System.out.println("Car Name : " + car.getName());
			System.out.println("Car Brand : " + car.getBrand());
			System.out.println("Car Cost : " + car.getCost());
			System.out.println("************************************");

		}
		return car;
	}
	public Car getCarByCost(int cost) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		String q = "select c from Car c where c.cost =?142";
		Query query = em.createQuery(q);
		query.setParameter(142, cost);
		Car car = (Car) query.getSingleResult();
		if (car != null) {
			System.out.println("Car Id : " + car.getId());
			System.out.println("Car Name : " + car.getName());
			System.out.println("Car Brand : " + car.getBrand());
			System.out.println("Car Cost : " + car.getCost());
			System.out.println("************************************");

		} else {
			System.out.println("No Such car with Given Id");
		}
		return car;
	}

	public List<Car> getCarBetweenRange(int low, int big) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		String q = "select c from Car c where c.cost >=?1 and c.cost<=?2";
		Query query = em.createQuery(q);
		query.setParameter(1, low);
		query.setParameter(2, big);
		List<Car> list = query.getResultList();
		for (Car car : list) {
			System.out.println("Car Id : " + car.getId());
			System.out.println("Car Name : " + car.getName());
			System.out.println("Car Brand : " + car.getBrand());
			System.out.println("Car Cost : " + car.getCost());
			System.out.println("************************************");
		}
		return list;
	}

	public boolean updateCar(int id) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Car car = em.find(Car.class, id);
		et.begin();
		if (car != null) {
			System.out.println("Enter Updated Name");
			car.setName(sc.nextLine());
			System.out.println("Enter Updated Brand");
			car.setBrand(sc.nextLine());
			System.out.println("Enter Updated Cost");
			car.setCost(sc.nextInt());
			em.merge(car);
			et.commit();
			return true;
		} else {
			System.out.println("No Such car with Given Id");
		}
		return false;
	}

	public boolean deleteCarById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Car car = em.find(Car.class, id);
		et.begin();
		if (car != null) {
			em.remove(car);
			et.commit();
			return true;
		} else {
			System.out.println("No Such car with Given Id");
		}
		return false;
	}

	public boolean deleteCarByName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("digvijay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String q = "select c from Car c where c.name=:AnyString";
		Query query = em.createQuery(q);
		query.setParameter("AnyString", name);
		Car car = (Car) query.getSingleResult();
		et.begin();
		if(car!=null) {
			em.remove(car);
			et.commit();
			return true;
		}else {
			System.out.println("No Such car with Given Id");
		}
		return false;
		
	}

}
