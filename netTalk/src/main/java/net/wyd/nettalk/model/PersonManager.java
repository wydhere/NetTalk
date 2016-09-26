package net.wyd.nettalk.model;

import java.util.*;

import net.wyd.nettalk.R;
import net.wyd.nettalk.utils.Utilities;

public final class PersonManager {
	private static PersonManager personManager = new PersonManager();
	private PersonManager() {
		personList = new ArrayList<Person>();
		sessionList = new ArrayList<Session>();
		init();
	}
	
	public static PersonManager getInstance() {
		return personManager;
	}
	
	private Session currentSession;
	private List<Person> personList;
	private List<Session> sessionList;
	
	private void init() {
		for(int i = 0; i < 20; i++) {
			Person person = new Person(Utilities.genString(8), Person.SEX.MALE, 0, R.drawable.alien, null);
			Session session = new Session(person);
			session.addMessage(new Message(Utilities.genString(80), Message.TYPE_RECEIVED));
			sessionList.add(session);
		}
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session session) {
		this.currentSession = session;
	}
	
	public List<Person> getPersonList() {
		return personList;
	}
	
	public List<Session> getSessionList() {
		return sessionList;
	}
}
