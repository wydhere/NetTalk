package net.wyd.nettalk.model;

import java.io.Serializable;
import java.util.ArrayList;

import net.wyd.nettalk.R;
import net.wyd.nettalk.utils.Utilities;


public class Person {
	public enum SEX {
		MALE,FEMALE
	}
	public static Person ME = new Person(Utilities.genString(15), Person.SEX.MALE, 0, R.drawable.devil, null);;
	private String name;
	private SEX sex;
	private long id;
	private String group;
	private int imageID;
	private ArrayList<Message> record = new ArrayList<Message>();
	
	public Person(String name, SEX sex, long id, int imageID, String group) {
		this.name = name;
		this.sex = sex;
		this.id = id;
		this.imageID = imageID;
		this.group = group;
	}
	
	public String getName() {
		return name;
	}
	
	public SEX getSex() {
		return sex;
	}
	
	public long getID() {
		return id;
	}
	
	public String getGroup() {
		return group;
	}
	
	public int getImageID() {
		return imageID;
	}
	
	public ArrayList<Message> getRecord() {
		return record;
	}
	
	public Message getLastMsg() {
		Message msg = null;
		if(!record.isEmpty()) {
			msg = record.get(record.size() - 1);
		}
		return msg;
	}
	
	public void addRecord(Message message) {
		record.add(message);
	}
}
