package com.car_simple_project.controller;

import java.util.Scanner;

import com.car_simple_project.dao.CarCrud;
import com.car_simple_project.entity.Car;

public class CarController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c=new Car();
		CarCrud carCrud=new CarCrud();
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		while(b) {
			System.out.println("Enter Your Choice \n1. Save car \n2. Get All Cars \n3. Get car By Id \n4. Get Car By Name \n5.  Get Car By Cost \n6.  Get Car Between range \n7. Update car \n8. Delete Car");
			int choice=sc.nextInt() ;
			switch(choice) {
			
			case 1:{
				System.out.println("Enter Car Name");
				c.setName(sc.next());
				System.out.println("Enter CarBrand");
				c.setBrand(sc.next());
				System.out.println("Enter Car Cost");
				c.setCost(sc.nextInt());
				carCrud.saveCar(c);
			}
			break;
			
			case 2:{
				carCrud.getAllCars();
			}
			break;
			
			case 3:{
				System.out.println("Enter Id to Get Car");
				int i=sc.nextInt();
				carCrud.getCarById(i);
			}
			break;
			
			case 4:{
				System.out.println("Enter Name of car");
				String name=sc.next();
				carCrud.getCarByName(name);
			}
			break;
			
			case 5:{
				System.out.println("Enter car cost you want");
				int cost=sc.nextInt();
				carCrud.getCarByCost(cost);
			}
			break;
			
			case 6:{
				System.out.println("Enter car Between Range");
				int low=sc.nextInt();
				int big=sc.nextInt();
				carCrud.getCarBetweenRange(low, big);
			}
			break;
			
			case 7:{
				System.out.println("Enter Id to Update the car");
				int id=sc.nextInt();
				carCrud.updateCar(id);
			}
			break;
			
			case 8:{
				System.out.println("Enter car id you want to delete");
				int id=sc.nextInt();
				carCrud.deleteCarById(id);
			}
			break;
			
			case 9:{
				System.out.println("Enter car name you want to delete");
				String name=sc.nextLine();
				carCrud.deleteCarByName(name);
			}
			break;
			
			default:{
				System.out.println("Invalid Detaails");
			}
			}
		}

	}

}
