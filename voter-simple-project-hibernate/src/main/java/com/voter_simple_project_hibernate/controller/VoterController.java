package com.voter_simple_project_hibernate.controller;

import java.util.Scanner;

import com.voter_simple_project_hibernate.dao.VoterCrud;
import com.voter_simple_project_hibernate.entity.Voter;

public class VoterController {
	public static void details() {
		System.out.println("Enter 1 to Save the Voter");
		System.out.println("Enter 2 to Get All Voter");
		System.out.println("Enter 3 to Get Voter by Id");
		System.out.println("Enter 4 to Get Voter by Name");
		System.out.println("Enter 5 to Update the Voter");
		System.out.println("Enter 6 to delete Voter by Id");
		System.out.println("Enter 7 to delete Voter by Name");
		System.out.println("Enter 8 to Exit");

	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		VoterCrud vc=new VoterCrud();
		Voter voter=new Voter();
		boolean exit=true;
		while(exit) {
			VoterController.details();
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1:{
				System.out.println("Enter Name");
				voter.setName(sc.next());
				System.out.println("Enter vardno");
				voter.setVardNo(sc.nextInt());
				System.out.println("Enter Address");
				voter.setAddress(sc.next());
				vc.saveVoter(voter);
			}
			break;
			
			case 2:{
				vc.getAllVoter();
			}
			break;
			
			case 3:{
				System.out.println("Enter id");
				int id=sc.nextInt();
				vc.getVoterById(id);
			}
			break;
			
			case 4:{
				System.out.println("Enter Name");
				String name=sc.next();
				vc.getVoterByName(name);
			}
			break;
			
			case 5:{
				System.out.println("Enter Id");
				int id=sc.nextInt();
				vc.updateVoter(id);

			}
			break;
			
			case 6:{
				System.out.println("Enter id");
				int id=sc.nextInt();
				vc.deleteById(id);

			}
			break;
			
			case 7:{
				System.out.println("Enter Name");
				String name=sc.next();
				vc.deleteByName(name);

			}
			break;
			
			case 8:{
				exit=false;
			}
			
			default:{
				System.out.println("Wrong credentials!");
			}
			}
			
		}

	}

}
