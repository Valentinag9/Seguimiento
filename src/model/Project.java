package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;


public class Project{
	
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
	private Type type;

	private DateFormat formatter;

	public Project(String name, String clientName, Type type, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");

		this.name = name;	
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
	}
	public String getname(){
		return name;
	}
	
	
	public String getClientName(){
		return clientName;
	}

	public Type getType() {
		return type;
	}
	
	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated()throws ParseException {
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated()throws ParseException {
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

	public String getProjectInfo()throws ParseException{
		return "\nName: " + name + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
	}
}


