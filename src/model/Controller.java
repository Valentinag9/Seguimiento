package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
	
	}
	
	//Incomplete
	public boolean RegisterProject(String name, String clientName , String type , int initialYear, int initialMonth , int initialDay , int finalYear, int finalMonth , int finalDay, double budget) {
		Type typePO = Type.DESARROLLO;
		if(type.equalsIgnoreCase("Despliegue")){
			typePO = Type.DESPLIEGUE;
		}else if (type.equalsIgnoreCase("Mantenimiento")){
			typePO = Type.MANTENIMIENTO;
		}
		Calendar initialDate = new GregorianCalendar(initialYear,initialMonth-1, initialDay);
		Calendar finalDate= new GregorianCalendar(finalYear, finalMonth-1, finalDay);

		Project newproject = new Project(name,clientName, typePO, initialDate , finalDate, budget);
		for(int i = 0; i<projects.length;i++){
			if(projects[i]==null){
				projects[i] = newproject;
				return true;
			}
		}
		return false;
	}

	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate(int day, int month, int year)throws ParseException {

		String msg = "";

		Calendar PlannedDate = new GregorianCalendar(year, month-1,day);
		for(int i = 0; i < projects.length; i++){
			if(projects[i]!=null){
				if(PlannedDate.compareTo(projects[i].getInitialDate()) == -1){
					msg += projects[i].getProjectInfo();
				}
			}
		}

		return msg;

	}
	
	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate(int day, int month, int year) throws ParseException{
		String msg = "";
		Calendar limitDate = new GregorianCalendar(year, month-1, day);
		for(int i = 0; i < projects.length; i++){
			if(projects[i]!=null){
				if(limitDate.compareTo(projects[i].getInitialDate()) == 1){
					msg += projects[i].getProjectInfo();
				}
			}
		}

		return msg;

	}
}
