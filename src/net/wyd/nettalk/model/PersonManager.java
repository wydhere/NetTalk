package net.wyd.nettalk.model;

import java.util.ArrayList;

import net.wyd.nettalk.R;

public final class PersonManager {
	private static PersonManager personManager = new PersonManager();
	private PersonManager() {
		personList = new ArrayList<Person>();
		recentList = new ArrayList<Person>();
		initRecentList();
	}
	
	public static PersonManager getInstance() {
		return personManager;
	}
	
	private Person currentContact;
	private ArrayList<Person> personList;
	private ArrayList<Person> recentList;
	
	private void initRecentList() {
		Person person = new Person("Name1", Person.SEX.FEMALE, 0, R.drawable.alien, null);
		person.addRecord(new Message("heiheihei", true));
		recentList.add(person);
		person = new Person("Name2", Person.SEX.FEMALE, 0, R.drawable.alien2, null);
		recentList.add(person);
		person = new Person("Name3", Person.SEX.FEMALE, 0, R.drawable.alien3, null);
		recentList.add(person);
		person = new Person("Name4", Person.SEX.FEMALE, 0, R.drawable.alien4, null);
		recentList.add(person);
		person = new Person("Name5", Person.SEX.FEMALE, 0, R.drawable.bat, null);
		recentList.add(person);
	}
	
	public Person getCurrentContact() {
		return currentContact;
	}
	
	public void setCurrentContact(Person currentContact) {
		this.currentContact = currentContact;
	}
	
	public ArrayList<Person> getPersonList() {
		return personList;
	}
	
	public ArrayList<Person> getRecentList() {
		return recentList;
	}
}
