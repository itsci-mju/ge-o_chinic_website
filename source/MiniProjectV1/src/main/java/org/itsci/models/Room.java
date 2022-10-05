package org.itsci.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	@Id
	private int room_id;
	@Column(length = 45)
	private String room;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int room_id, String room) {
		super();
		this.room_id = room_id;
		this.room = room;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	
}
