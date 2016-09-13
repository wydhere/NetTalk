package net.wyd.nettalk.model;

import java.util.ArrayList;

import android.R.integer;
import android.graphics.Bitmap;

public class Person {
	public enum SEX {
		MALE,FEMALE
	}
	private String name;
	private SEX sex;
	private long id;
	private String group;
	private long time;
	private int imageID;
	private ArrayList<Message> record = new ArrayList<Message>();
	
	public Person(String name, SEX sex, long id, int imageID, String group) {
		this.name = name;
		this.sex = sex;
		this.id = id;
		this.imageID = imageID;
		this.group = group;
		this.time = System.currentTimeMillis();
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
	
	public long getTime() {
		return time;
	}
	
	public int getImageID() {
		return imageID;
	}
	
	public ArrayList<Message> getRecord() {
		return record;
	}
	
	public Message getLastRecord() {
		if(record.size() > 0)
			return record.get(record.size() - 1);
		return null;
	}
	
	public void addRecord(Message message) {
		record.add(message);
	}
}
