package net.wyd.nettalk.model;

import java.io.Serializable;

import net.wyd.nettalk.utils.Utilities;

public class Message implements Serializable {
	
	public static final int TYPE_RECEIVED = 0;
	public static final int TYPE_SENT = 1;
	static final long serialVersionUID = 1L;
	private Person sender;
	private String msg;
	private int type;
	private long time;
	private Session session;
	
	public Message(String msg, int type) {
		this.msg = msg;
		this.type = type;
		this.time = System.currentTimeMillis();
	}
	
	public Person getSender() {
		return sender;
	}
	
	public void setSender(Person sender) {
		this.sender = sender;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public int getType() {
		return type;
	}
	
	public String getTime() {
		return Utilities.formatTime(time);
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
}
