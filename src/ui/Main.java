package ui;

import java.util.Scanner;
import model.Controller;
import java.text.ParseException;

public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) throws ParseException{

		Main exe = new Main();
		exe.menu();

	}

	// Incomplete
	public void menu() throws ParseException{
		System.out.println("Welcome to GreenSQA ");

		boolean exit = false;

		while(!exit){
			System.out.println("1. Create a new project");
			System.out.println("Consult projects according to their date:");
			System.out.println("2. Projects ending before a date");
			System.out.println("3. Projects that start after a date");
			System.out.println("4. Exit");
			int option = reader.nextInt();

			switch(option){
			
			case 1: 
				RegisterProject();
				break; 
			case 2: 
				searchProjectsAfterDate();
				break;
			case 3: 
				searchProjectsBeforeDate();
				break;
			case 4:
				exit = true;
				break;
			}
		}

	}

	//Incomplete
	public void RegisterProject() {
		System.out.println("Enter the information of the new project below");

		reader.nextLine();

		
		System.out.println("Enter the name of the project");
		String name = reader.nextLine();
		System.out.println("Enter the name of the client");
		String clientName = reader.nextLine();
		System.out.println("Type the type of project \n1.Development \n2.Maintenance \n3.Deployment ");
		String type = reader.nextLine();
		

		System.out.println("Type the starting day of the project:");
		int initialDay = reader.nextInt();
		System.out.println("Enter the starting month of the project:");
		int initialMonth = reader.nextInt();
		System.out.println("Enter the starting year of the project:");
		int initialYear= reader.nextInt();


		System.out.println("Type the final day of the project:");
		int finalDay = reader.nextInt();
		System.out.println("Enter the final month of the project:");
		int finalMonth = reader.nextInt();
		System.out.println("Enter the final year of the project:");
		int finalYear= reader.nextInt();

		System.out.println("Enter the budget of the project:");
		double budget = reader.nextDouble();

		if(controller.RegisterProject(name,clientName,type,initialYear, initialMonth,initialDay,finalDay, finalYear, finalMonth, budget)){
			System.out.println("Project registered successfully");
		}else{
			System.out.println("Failed to register project");
		}
	}

	//Incomplete
	public void searchProjectsAfterDate() throws ParseException {
		System.out.println("Type the Day:");
		int day = reader.nextInt();
		System.out.println("Type the Month: ");
		int month = reader.nextInt();
		System.out.println("Type the Year: ");
		int year = reader.nextInt();
		System.out.println(controller.searchProjectsAfterDate(day, month, year));
	}
	
	//Incomplete
	public void searchProjectsBeforeDate() throws ParseException {
		System.out.println("Type the Day:");
		int day = reader.nextInt();
		System.out.println("Type the Month:");
		int month = reader.nextInt();
		System.out.println("Type the year:"); 
		int year =	reader.nextInt();
		System.out.println(controller.searchProjectsBeforeDate(day, month, year));
	}

}
