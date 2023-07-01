package org.itsci.models;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int room_id;
	@Column(length = 45)
	private String room;
	
	@ManyToOne
	@JoinColumn(name = "expertise_FK",nullable = false)
	private Expertise expertise;
	
	@OneToMany(mappedBy="room")
	private List<AppoinmentWeekDay> appoinmentweekday = new Vector<>();

	
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
	public Expertise getExpertise() {
		return expertise;
	}
	public void setExpertise(Expertise expertise) {
		this.expertise = expertise;
	}
	
	
}
