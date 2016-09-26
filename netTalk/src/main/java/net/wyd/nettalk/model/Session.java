package net.wyd.nettalk.model;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import android.R.integer;


public class Session {
	public static final int SESSION_SINGLE = 0;
	public static final int SESSION_MULTI = 1;
	private static BitSet bitMask = new BitSet();
	private int sessionID = -1;
	private int sessionStyle;
	private Person contact;
	private List<Message> messages;
	private Message lastMsg;
	
	public Session(Person contact, List<Message> messages) {
		this.sessionStyle = SESSION_SINGLE;
		this.contact = contact;
		this.messages = messages;
		if(messages != null && !messages.isEmpty())
			this.lastMsg = messages.get(messages.size() - 1);
		initID();
	}
	public Session(Person contact) {
		this(contact, new ArrayList<Message>());
	}
	
	public Session(int sessionID, Person contact, List<Message> messages) {
		this(contact, messages);
		this.sessionID = sessionID;
		bitMask.set(sessionID);
	}
	
	private void initID() {
		for (int i = 0; i < bitMask.length(); i++) {
			if(!bitMask.get(i)) {
				sessionID = i;
				bitMask.set(i);
				break;
			}
		}
	}
	
	public void addMessage(Message msg) {
		switch (sessionStyle) {
		case SESSION_SINGLE:
			if(msg.getType() == Message.TYPE_RECEIVED)
				msg.setSender(contact);
			else
				msg.setSender(Person.ME);
			lastMsg = msg;
			msg.setSession(this);
			messages.add(msg);
			break;

		default:
			break;
		}
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public Message getLastMsg() {
		return lastMsg;
	}
	
	public int getImageID() {
		int imageID = -1;
		switch (sessionStyle) {
		case SESSION_SINGLE:
			imageID = contact.getImageID();
			break;

		default:
			break;
		}
		return imageID;
	}
	
	public String getName() {
		String name = null;
		switch (sessionStyle) {
		case SESSION_SINGLE:
			name = contact.getName();
			break;

		default:
			break;
		}
		return name;
	}
}
