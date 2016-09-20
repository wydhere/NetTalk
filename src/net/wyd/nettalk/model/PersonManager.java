package net.wyd.nettalk.model;

import java.util.ArrayList;

import net.wyd.nettalk.R;
import net.wyd.nettalk.utils.Utilities;

public final class PersonManager {
	private static PersonManager personManager = new PersonManager();
	private PersonManager() {
		me = new Person(Utilities.genString(15), Person.SEX.MALE, 0, R.drawable.devil, null);
		personList = new ArrayList<Person>();
		recentList = new ArrayList<Person>();
		initRecentList();
	}
	
	public static PersonManager getInstance() {
		return personManager;
	}
	
	private Person me;
	private Person currentContact;
	private ArrayList<Person> personList;
	private ArrayList<Person> recentList;
	
	private void initRecentList() {
		Person person = new Person("Name1", Person.SEX.FEMALE, 0, R.drawable.alien, null);
		person.addRecord(new Message(Utilities.genString(100), Message.TYPE_RECEIVED, person));
		recentList.add(person);
		person = new Person("Name2", Person.SEX.FEMALE, 0, R.drawable.alien2, null);
		person.addRecord(new Message(Utilities.genString(100), Message.TYPE_RECEIVED, person));
		recentList.add(person);
		person = new Person("Name3", Person.SEX.FEMALE, 0, R.drawable.alien3, null);
		person.addRecord(new Message(Utilities.genString(100), Message.TYPE_RECEIVED, person));
		recentList.add(person);
		person = new Person("Name4", Person.SEX.FEMALE, 0, R.drawable.alien4, null);
		person.addRecord(new Message(Utilities.genString(100), Message.TYPE_RECEIVED, person));
		recentList.add(person);
		person = new Person("Name5", Person.SEX.FEMALE, 0, R.drawable.bat, null);
		person.addRecord(new Message(Utilities.genString(100), Message.TYPE_RECEIVED, person));
		recentList.add(person);
		for(int i = 0; i < 20; i++) 
			recentList.add(person);
	}
	
	public Person getMe() {
		return me;
	}
	
	public void setMe(Person me) {
		this.me = me;
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
