package net.wyd.nettalk.model;

import java.io.Serializable;

public class Message implements Serializable {
	static final long serialVersionUID = 1L;
	private String msg;
	private boolean isSent = false;
	
	public Message(String msg, boolean isSent) {
		this.msg = msg;
		this.isSent = isSent;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isSent() {
		return isSent;
	}
}
