package net.wyd.nettalk.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Person implements Serializable {
	public enum SEX {
		MALE,FEMALE
	}
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
	
	public String getLastMsg() {
		String msg = null;
		if(!record.isEmpty()) {
			msg = record.get(record.size() - 1).getMsg();
		}
		return msg;
	}
	
	public void addRecord(Message message) {
		record.add(message);
	}
}
